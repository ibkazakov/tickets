package zenIT.tickets.testtask.timetable.dto;

public class SessionDto {
    private Long id;

    private java.sql.Time beginTime;
    private java.sql.Time endTime;

    public SessionDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
