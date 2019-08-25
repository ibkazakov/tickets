package zenIT.tickets.testtask.sits.model;

import javax.persistence.*;

@Entity
@Table(name = "sit")
public class Sit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long ID;

    @Column(name = "range")
    private Integer range;

    @Column(name = "rangeSit")
    private Integer rangeSit;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    public Sit() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getRangeSit() {
        return rangeSit;
    }

    public void setRangeSit(Integer rangeSit) {
        this.rangeSit = rangeSit;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
