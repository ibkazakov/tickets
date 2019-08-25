package zenIT.tickets.testtask.sits.dto.mapper;

import org.springframework.stereotype.Component;
import zenIT.tickets.testtask.sits.dto.HallDto;
import zenIT.tickets.testtask.sits.dto.SitDto;
import zenIT.tickets.testtask.sits.model.Hall;
import zenIT.tickets.testtask.sits.model.Sit;

import java.util.ArrayList;
import java.util.List;

@Component
public class HallMapper {
    public SitDto toDto(Sit sit) {
        SitDto sitDto = new SitDto();
        sitDto.setId(sit.getID());
        sitDto.setRange(sit.getRange());
        sitDto.setRangeSit(sit.getRangeSit());
        return sitDto;
    }

    public HallDto toDto(Hall hall) {
        HallDto hallDto = new HallDto();
        hallDto.setId(hall.getID());
        hallDto.setName(hall.getName());
        hallDto.setCity(hall.getCity());
        hallDto.setSitsNumber(hall.getAllSits().size());
        return hallDto;
    }

    public List<HallDto> toDto(List<Hall> hallList) {
        List<HallDto> hallDtos = new ArrayList<HallDto>();
        for (Hall hall : hallList) {
            hallDtos.add(toDto(hall));
        }
        return hallDtos;
    }
}
