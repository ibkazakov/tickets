package zenIT.tickets.testtask.orders.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zenIT.tickets.testtask.orders.dto.ClientDto;
import zenIT.tickets.testtask.orders.dto.OrderDto;
import zenIT.tickets.testtask.orders.model.Client;
import zenIT.tickets.testtask.orders.model.Order;
import zenIT.tickets.testtask.orders.model.OrderSits;
import zenIT.tickets.testtask.sits.dto.SitDto;
import zenIT.tickets.testtask.sits.dto.mapper.HallMapper;
import zenIT.tickets.testtask.sits.model.Sit;
import zenIT.tickets.testtask.timetable.dto.mapper.TimeTableMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class OrderMapper {

    @Autowired
    HallMapper hallMapper;

    @Autowired
    TimeTableMapper timeTableMapper;

    public ClientDto toDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setID(client.getId());
        clientDto.setEmail(client.getEmail());
        clientDto.setName(client.getName());
        clientDto.setPhone(client.getPhone());
        return clientDto;
    }

    public List<ClientDto> toDtoClientList(List<Client> clientList) {
        List<ClientDto> clientDtoList = new ArrayList<ClientDto>();
        for(Client client : clientList) {
            clientDtoList.add(toDto(client));
        }
        return clientDtoList;
    }

    public OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setClient(toDto(order.getClient()));
        orderDto.setID(order.getId());
        orderDto.setTimeTableDto(timeTableMapper.toDto(order.getTimeTable()));
        Set<SitDto> sitDtos = new HashSet<SitDto>();
        for(OrderSits orderSit : order.getSits()) {
            Sit sit = orderSit.getSit();
            sitDtos.add(hallMapper.toDto(sit));
        }
        orderDto.setSits(sitDtos);
        return orderDto;
    }

    public List<OrderDto> toDtoOrderList(List<Order> orderList) {
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
        for(Order order : orderList) {
            orderDtoList.add(toDto(order));
        }
        return orderDtoList;
    }
}
