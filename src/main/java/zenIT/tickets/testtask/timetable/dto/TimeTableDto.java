package zenIT.tickets.testtask.timetable.dto;

import zenIT.tickets.testtask.movies.dto.MovieDto;
import zenIT.tickets.testtask.sits.dto.HallDto;

public class TimeTableDto {
    private Long id;

    private java.sql.Date day;

    private HallDto hall;
    private MovieDto movie;
    private SessionDto session;

    public TimeTableDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Date getDay() {
        return day;
    }

    public void setDay(java.sql.Date day) {
        this.day = day;
    }

    public HallDto getHall() {
        return hall;
    }

    public void setHall(HallDto hall) {
        this.hall = hall;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }

    public SessionDto getSession() {
        return session;
    }

    public void setSession(SessionDto session) {
        this.session = session;
    }
}
