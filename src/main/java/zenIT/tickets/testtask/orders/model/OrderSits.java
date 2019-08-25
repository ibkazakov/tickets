package zenIT.tickets.testtask.orders.model;

import zenIT.tickets.testtask.sits.model.Sit;

import javax.persistence.*;

@Entity
@Table(name = "order_sits", uniqueConstraints = @UniqueConstraint(columnNames = {"sit_id"}))
public class OrderSits {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "sit_id")
    private Sit sit;

    public OrderSits() {
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Sit getSit() {
        return sit;
    }

    public void setSit(Sit sit) {
        this.sit = sit;
    }
}
