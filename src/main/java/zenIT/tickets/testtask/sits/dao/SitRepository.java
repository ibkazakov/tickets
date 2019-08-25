package zenIT.tickets.testtask.sits.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zenIT.tickets.testtask.sits.model.Sit;

@Repository
public interface SitRepository extends CrudRepository<Sit, Long> {
}
