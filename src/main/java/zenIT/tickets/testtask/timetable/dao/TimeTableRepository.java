package zenIT.tickets.testtask.timetable.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zenIT.tickets.testtask.timetable.model.TimeTable;

@Repository
public interface TimeTableRepository extends CrudRepository<TimeTable, Long> {
}
