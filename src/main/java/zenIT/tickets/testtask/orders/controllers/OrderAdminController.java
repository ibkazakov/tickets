package zenIT.tickets.testtask.orders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zenIT.tickets.testtask.orders.dto.mapper.OrderMapper;
import zenIT.tickets.testtask.orders.model.Client;
import zenIT.tickets.testtask.orders.model.Order;
import zenIT.tickets.testtask.orders.service.ClientService;
import zenIT.tickets.testtask.orders.service.OrderService;
import zenIT.tickets.testtask.sits.dto.mapper.HallMapper;
import zenIT.tickets.testtask.sits.model.Sit;

import java.util.List;

@Controller
@RequestMapping("/admin/orders")
public class OrderAdminController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private HallMapper hallMapper;

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public ResponseEntity<?> createClient(@RequestParam("name") String name,
                                          @RequestParam("phone") String phone, @RequestParam("email") String email) {
        Client client = clientService.createClient(name, phone, email);
        if (client == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(mapper.toDto(client));
    }

    @RequestMapping(value = "/allClients", method = RequestMethod.GET)
    public ResponseEntity<?> viewAllClients() {
        List<Client> clientList = clientService.getAllClients();
        return ResponseEntity.ok(mapper.toDtoClientList(clientList));
    }

    @RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteClientById(@PathVariable("id") Long id) {
        boolean isDeleted = clientService.deleteClientById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Client with id " + id + "has been successfully removed");
        } else {
            return ResponseEntity.ok("Client with id " + id + "cannot be removed");
        }
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestParam("client_id") Long client_id,
                                         @RequestParam("timetable_id") Long timetable_id) {
        Order order = orderService.createOrder(client_id, timetable_id);
        if (order == null) {
            return null;
        }
        return ResponseEntity.ok(mapper.toDto(order));
    }

    @RequestMapping(value = "/allOrders", method = RequestMethod.GET)
    public ResponseEntity<?> viewAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        return ResponseEntity.ok(mapper.toDtoOrderList(orderList));
    }

    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteOrderById(@PathVariable("id") Long id) {
        boolean isDeleted = orderService.deleteOrderById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Order with id " + id + "has been successfully removed");
        } else {
            return ResponseEntity.ok("Order with id " + id + "cannot be removed");
        }
    }

    @RequestMapping(value = "/addSit", method = RequestMethod.POST)
    public ResponseEntity<?> addSitToOrder(@RequestParam("order_id") Long order_id, @RequestParam("sit_id") Long sit_id) {
        Sit sit = orderService.addSitToOrder(order_id, sit_id);
        if (sit == null) {
            return null;
        }
        return ResponseEntity.ok(hallMapper.toDto(sit));
    }
}
