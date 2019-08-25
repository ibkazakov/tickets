package zenIT.tickets.testtask.timetable.model;

import zenIT.tickets.testtask.movies.model.Movie;
import zenIT.tickets.testtask.sits.model.Hall;

import javax.persistence.*;

@Entity
@Table(name = "time_table", uniqueConstraints = @UniqueConstraint(columnNames = {"day", "hall_id", "session_id"}))
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long ID;

    @Column(name = "day")
    private java.sql.Date day;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public TimeTable() {
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public java.sql.Date getDay() {
        return day;
    }

    public void setDay(java.sql.Date day) {
        this.day = day;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
