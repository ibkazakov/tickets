package zenIT.tickets.testtask.orders.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zenIT.tickets.testtask.orders.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
