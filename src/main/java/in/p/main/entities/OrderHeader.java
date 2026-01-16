package in.p.main.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "order_header")
@Getter
@Setter
public class OrderHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    private LocalDate orderDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_contact_mech_id")
    private ContactMech shippingContactMech;

    @ManyToOne
    @JoinColumn(name = "billing_contact_mech_id")
    private ContactMech billingContactMech;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ContactMech getShippingContactMech() {
		return shippingContactMech;
	}

	public void setShippingContactMech(ContactMech contactMech) {
		this.shippingContactMech = contactMech;
	}

	public ContactMech getBillingContactMech() {
		return billingContactMech;
	}

	public void setBillingContactMech(ContactMech billingContactMech) {
		this.billingContactMech = billingContactMech;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	

	

    
}
