package zenIT.tickets.testtask.orders.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zenIT.tickets.testtask.orders.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
