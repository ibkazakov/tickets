package zenIT.tickets.testtask.timetable.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zenIT.tickets.testtask.movies.dto.mapper.MovieMapper;
import zenIT.tickets.testtask.sits.dto.mapper.HallMapper;
import zenIT.tickets.testtask.timetable.dto.SessionDto;
import zenIT.tickets.testtask.timetable.dto.TimeTableDto;
import zenIT.tickets.testtask.timetable.model.Session;
import zenIT.tickets.testtask.timetable.model.TimeTable;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimeTableMapper {
    @Autowired
    MovieMapper movieMapper;

    @Autowired
    HallMapper hallMapper;

    public SessionDto toDto(Session session) {
        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(session.getID());
        sessionDto.setBeginTime(session.getBeginTime());
        sessionDto.setEndTime(session.getEndTime());
        return sessionDto;
    }

    public TimeTableDto toDto(TimeTable timeTable) {
        TimeTableDto timeTableDto = new TimeTableDto();
        timeTableDto.setId(timeTable.getID());
        timeTableDto.setDay(timeTable.getDay());
        timeTableDto.setHall(hallMapper.toDto(timeTable.getHall()));
        timeTableDto.setMovie(movieMapper.toDto(timeTable.getMovie()));
        timeTableDto.setSession(toDto(timeTable.getSession()));
        return timeTableDto;
    }

    public List<TimeTableDto> toTimeTableDto(List<TimeTable> timeTableList) {
        List<TimeTableDto> timeTableDtoList = new ArrayList<TimeTableDto>();
        for(TimeTable timeTable : timeTableList) {
            timeTableDtoList.add(toDto(timeTable));
        }
        return timeTableDtoList;
    }

    public List<SessionDto> toSessionDto(List<Session> sessionList) {
        List<SessionDto> sessionDtoList = new ArrayList<SessionDto>();
        for(Session session : sessionList) {
            sessionDtoList.add(toDto(session));
        }
        return sessionDtoList;
    }
}
