package in.p.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "order_header")
public class OrderHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_contact_mech_id")
    @JsonIgnore
    private ContactMech shippingContactMech;

    @ManyToOne
    @JoinColumn(name = "billing_contact_mech_id")
    @JsonIgnore
    private ContactMech billingContactMech;

    @OneToMany(mappedBy = "orderHeader", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItem> orderItems;

    // getters & setters
}
