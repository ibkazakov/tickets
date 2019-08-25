package zenIT.tickets.testtask.sits.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long ID;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL)
    private Set<Sit> allSits;

    public Hall() {
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Sit> getAllSits() {
        return allSits;
    }

    public void setAllSits(Set<Sit> allSits) {
        this.allSits = allSits;
    }
}
