package zenIT.tickets.testtask.sits.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zenIT.tickets.testtask.sits.dto.mapper.HallMapper;
import zenIT.tickets.testtask.sits.model.Hall;
import zenIT.tickets.testtask.sits.service.HallService;

import java.util.List;

@Controller
@RequestMapping("/admin/halls")
public class HallAdminController {
    @Autowired
    HallService hallService;

    @Autowired
    HallMapper mapper;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addHall(@RequestParam("city") String city, @RequestParam("name") String name,
                                     @RequestParam("rangeSits[]") Integer[] rangeSits) {
        Hall newHall = hallService.createHall(name, city, rangeSits);
        return ResponseEntity.ok(mapper.toDto(newHall));
    }

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public ResponseEntity<?> viewAllHalls() {
        List<Hall> hallList = hallService.getAllHalls();
        return ResponseEntity.ok(mapper.toDto(hallList));
    }

    @RequestMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteHall(@PathVariable("id") Long id) {
        boolean isDeleted = hallService.deleteHallbyId(id);
        if (isDeleted) {
            return ResponseEntity.ok("Hall with id " + id + "has been successfully removed");
        } else {
            return ResponseEntity.ok("Hall with id " + id + "cannot be removed");
        }
    }

}
