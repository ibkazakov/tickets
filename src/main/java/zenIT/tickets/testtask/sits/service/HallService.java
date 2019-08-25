package zenIT.tickets.testtask.sits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zenIT.tickets.testtask.sits.dao.HallRepository;
import zenIT.tickets.testtask.sits.model.Hall;
import zenIT.tickets.testtask.sits.model.Sit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    public Hall createHall(String name, String city, Integer[] rangeSits) {
        Hall newHall = new Hall();
        newHall.setName(name);
        newHall.setCity(city);

        Set<Sit> allSits = new HashSet<Sit>();
        for(int i = 0; i < rangeSits.length; i++) {
            int sitsInRange = rangeSits[i];
            for(int j = 0; j < sitsInRange; j++) {
                Sit sit = new Sit();
                sit.setHall(newHall);
                sit.setRange(i + 1);
                sit.setRangeSit(j + 1);
                allSits.add(sit);
            }
        }
        newHall.setAllSits(allSits);

        hallRepository.save(newHall);
        return newHall;
    }

    public Hall getHallById(Long id) {
        try {
            Hall hall = hallRepository.findById(id).get();
            return hall;
        }
        catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Hall> getAllHalls() {
        return StreamSupport.stream(hallRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public boolean deleteHallbyId(Long id) {
        if (!hallRepository.existsById(id)) {
            return false;
        }
        hallRepository.deleteById(id);
        return true;
    }

}
