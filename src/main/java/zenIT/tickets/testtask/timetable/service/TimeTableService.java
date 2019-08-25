package zenIT.tickets.testtask.timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zenIT.tickets.testtask.movies.dao.MovieRepository;
import zenIT.tickets.testtask.movies.model.Movie;
import zenIT.tickets.testtask.sits.dao.HallRepository;
import zenIT.tickets.testtask.sits.model.Hall;
import zenIT.tickets.testtask.timetable.dao.SessionRepository;
import zenIT.tickets.testtask.timetable.dao.TimeTableRepository;
import zenIT.tickets.testtask.timetable.model.Session;
import zenIT.tickets.testtask.timetable.model.TimeTable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TimeTableService {
    @Autowired
    TimeTableRepository timeTableRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    HallRepository hallRepository;

    public TimeTable createRecord(String day_string, Long session_id, Long hall_id, Long movie_id) {
        try {
            TimeTable newTimeTable = new TimeTable();
            Session session = sessionRepository.findById(session_id).get();
            Movie movie = movieRepository.findById(movie_id).get();
            Hall hall = hallRepository.findById(hall_id).get();
            java.sql.Date day = java.sql.Date.valueOf(day_string);
            newTimeTable.setDay(day);
            newTimeTable.setHall(hall);
            newTimeTable.setMovie(movie);
            newTimeTable.setSession(session);

            timeTableRepository.save(newTimeTable);
            return newTimeTable;
        }
        catch (Exception e) {
            return null;
        }
    }

    public List<TimeTable> viewAllRecords() {
        return StreamSupport.stream(timeTableRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public boolean deleteRecordbyId(Long id) {
        if (!timeTableRepository.existsById(id)) {
            return false;
        }
        timeTableRepository.deleteById(id);
        return true;
    }

}
