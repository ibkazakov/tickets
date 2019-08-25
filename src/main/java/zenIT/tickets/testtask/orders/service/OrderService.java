package zenIT.tickets.testtask.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zenIT.tickets.testtask.orders.dao.ClientRepository;
import zenIT.tickets.testtask.orders.dao.OrderRepository;
import zenIT.tickets.testtask.orders.dao.OrderSitsRepository;
import zenIT.tickets.testtask.orders.model.Client;
import zenIT.tickets.testtask.orders.model.Order;
import zenIT.tickets.testtask.orders.model.OrderSits;
import zenIT.tickets.testtask.sits.dao.SitRepository;
import zenIT.tickets.testtask.sits.model.Sit;
import zenIT.tickets.testtask.timetable.dao.TimeTableRepository;
import zenIT.tickets.testtask.timetable.model.TimeTable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TimeTableRepository timeTableRepository;

    @Autowired
    SitRepository sitRepository;

    @Autowired
    OrderSitsRepository orderSitsRepository;

    public Order createOrder(Long client_id, Long timetable_id) {
        try {
            Order newOrder = new Order();
            Client client = clientRepository.findById(client_id).get();
            TimeTable timeTable = timeTableRepository.findById(timetable_id).get();
            newOrder.setClient(client);
            newOrder.setTimeTable(timeTable);
            newOrder.setSits(new HashSet<OrderSits>());

            orderRepository.save(newOrder);
            return newOrder;
        }
        catch (Exception e) {
            return null;
        }
    }

    public Sit addSitToOrder(Long order_id, Long sit_id) {
        try {
            Order order = orderRepository.findById(order_id).get();
            Sit sit = sitRepository.findById(sit_id).get();
            Set<Sit> possibleSits = order.getTimeTable().getHall().getAllSits();
            if (!possibleSits.contains(sit)) {
                throw new Exception("sit is not possible for this order");
            }
            OrderSits orderSit = new OrderSits();
            orderSit.setOrder(order);
            orderSit.setSit(sit);
            order.getSits().add(orderSit);
            orderSitsRepository.save(orderSit);
            orderRepository.save(order);
            return sit;
        }
        catch (Exception e) {
            return null;
        }
    }

    public List<Order> getAllOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public boolean deleteOrderById(Long id) {
        if (!orderRepository.existsById(id)) {
            return false;
        }
        orderRepository.deleteById(id);
        return true;
    }
}
