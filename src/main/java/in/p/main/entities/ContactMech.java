package in.p.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "contact_mech")
public class ContactMech {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactMechId;

    private String address;

    @OneToMany(mappedBy = "shippingContactMech")
    @JsonIgnore
    private List<OrderHeader> shippingOrders;

    @OneToMany(mappedBy = "billingContactMech")
    @JsonIgnore
    private List<OrderHeader> billingOrders;

    // getters & setters
}
