package zenIT.tickets.testtask.timetable.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zenIT.tickets.testtask.timetable.model.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
}
