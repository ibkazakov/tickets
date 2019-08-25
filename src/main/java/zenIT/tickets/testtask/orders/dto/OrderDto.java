package zenIT.tickets.testtask.orders.dto;

import zenIT.tickets.testtask.sits.dto.SitDto;
import zenIT.tickets.testtask.timetable.dto.TimeTableDto;

import java.util.Set;

public class OrderDto {
    private Long ID;

    private ClientDto client;

    private TimeTableDto timeTableDto;

    private Set<SitDto> sits;

    public OrderDto() {
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public TimeTableDto getTimeTableDto() {
        return timeTableDto;
    }

    public void setTimeTableDto(TimeTableDto timeTableDto) {
        this.timeTableDto = timeTableDto;
    }

    public Set<SitDto> getSits() {
        return sits;
    }

    public void setSits(Set<SitDto> sits) {
        this.sits = sits;
    }
}
