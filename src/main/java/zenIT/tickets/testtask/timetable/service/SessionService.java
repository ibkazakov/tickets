package zenIT.tickets.testtask.timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zenIT.tickets.testtask.timetable.dao.SessionRepository;
import zenIT.tickets.testtask.timetable.model.Session;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class SessionService {
    @Autowired
    SessionRepository sessionRepository;

    public Session createSession(String begin, String end) {
        Session newSession = new Session();
        try {
            java.sql.Time beginTime = java.sql.Time.valueOf(begin);
            java.sql.Time endTime = java.sql.Time.valueOf(end);
            newSession.setBeginTime(beginTime);
            newSession.setEndTime(endTime);
            sessionRepository.save(newSession);
        }
        catch (Exception e) {
            return null;
        }
        return newSession;
    }

    public List<Session> getAllSessions() {
        return StreamSupport.stream(sessionRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public boolean deleteSessionbyId(Long id) {
        if (!sessionRepository.existsById(id)) {
            return false;
        }
        sessionRepository.deleteById(id);
        return true;
    }


}

