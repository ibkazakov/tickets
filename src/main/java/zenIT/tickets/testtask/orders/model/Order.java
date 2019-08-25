package zenIT.tickets.testtask.orders.model;

import zenIT.tickets.testtask.timetable.model.TimeTable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "timetable_id")
    private TimeTable timeTable;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @Column(name = "order_sits")
    private Set<OrderSits> sits;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    public Set<OrderSits> getSits() {
        return sits;
    }

    public void setSits(Set<OrderSits> sits) {
        this.sits = sits;
    }
}
