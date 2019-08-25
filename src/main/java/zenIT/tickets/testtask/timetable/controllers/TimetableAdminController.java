package zenIT.tickets.testtask.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zenIT.tickets.testtask.timetable.dto.mapper.TimeTableMapper;
import zenIT.tickets.testtask.timetable.model.Session;
import zenIT.tickets.testtask.timetable.model.TimeTable;
import zenIT.tickets.testtask.timetable.service.SessionService;
import zenIT.tickets.testtask.timetable.service.TimeTableService;

import java.util.List;

@Controller
@RequestMapping("/admin/timetable")
public class TimetableAdminController {
    @Autowired
    TimeTableMapper mapper;

    @Autowired
    SessionService sessionService;

    @Autowired
    TimeTableService timeTableService;

    @RequestMapping(value = "/addSession", method = RequestMethod.POST)
    public ResponseEntity<?> addSession(@RequestParam("begin") String begin,
                                        @RequestParam("end") String end) {
        Session session = sessionService.createSession(begin, end);
        if (session == null) {
            return null;
        }
        return ResponseEntity.ok(mapper.toDto(session));
    }

    @RequestMapping(value = "/allSessions", method = RequestMethod.GET)
    public ResponseEntity<?> viewAllSessions() {
        List<Session> sessionList = sessionService.getAllSessions();
        return ResponseEntity.ok(mapper.toSessionDto(sessionList));
    }

    @RequestMapping(value = "/deleteSession/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteSession(@PathVariable("id") Long id) {
        boolean isDeleted = sessionService.deleteSessionbyId(id);
        if (isDeleted) {
            return ResponseEntity.ok("Session with id " + id + "has been successfully removed");
        } else {
            return ResponseEntity.ok("Session with id " + id + "cannot be removed");
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addRecord(@RequestParam("day") String day, @RequestParam("session_id") Long session_id,
                                       @RequestParam("hall_id") Long hall_id, @RequestParam("movie_id") Long movie_id) {
        TimeTable timeTable = timeTableService.createRecord(day, session_id, hall_id, movie_id);
        if (timeTable == null) {
            return null;
        }
        return ResponseEntity.ok(mapper.toDto(timeTable));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> viewAllRecords() {
        List<TimeTable> timeTables = timeTableService.viewAllRecords();
        return ResponseEntity.ok(mapper.toTimeTableDto(timeTables));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteRecord(@PathVariable("id") Long id) {
        boolean isDeleted = timeTableService.deleteRecordbyId(id);
        if (isDeleted) {
            return ResponseEntity.ok("Record with id " + id + "has been successfully removed");
        } else {
            return ResponseEntity.ok("Record with id " + id + "cannot be removed");
        }
    }


}
