package zenIT.tickets.testtask.orders.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zenIT.tickets.testtask.orders.model.OrderSits;

@Repository
public interface OrderSitsRepository extends CrudRepository<OrderSits, Long> {
}
