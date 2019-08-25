package zenIT.tickets.testtask.sits.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zenIT.tickets.testtask.sits.model.Hall;

@Repository
public interface HallRepository extends CrudRepository<Hall, Long> {
}
