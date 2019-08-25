package zenIT.tickets.testtask.timetable.model;

import javax.persistence.*;

@Entity
@Table(name = "time_session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long ID;

    @Column(name = "beginTime")
    private java.sql.Time beginTime;

    @Column(name = "endTime")
    private java.sql.Time endTime;

    public Session() {
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public java.sql.Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(java.sql.Time beginTime) {
        this.beginTime = beginTime;
    }

    public java.sql.Time getEndTime() {
        return endTime;
    }

    public void setEndTime(java.sql.Time endTime) {
        this.endTime = endTime;
    }
}
