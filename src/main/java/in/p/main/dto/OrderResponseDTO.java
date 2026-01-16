package in.p.main.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderResponseDTO {

    private Long orderId;
    private LocalDate orderDate;
    private String status;
    private Long customerId;

    private Long billingContactMechId;
    private Long shippingContactMechId;

    private List<OrderItemDTO> items;

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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getBillingContactMechId() {
		return billingContactMechId;
	}

	public void setBillingContactMechId(Long billingContactMechId) {
		this.billingContactMechId = billingContactMechId;
	}

	public Long getShippingContactMechId() {
		return shippingContactMechId;
	}

	public void setShippingContactMechId(Long shippingContactMechId) {
		this.shippingContactMechId = shippingContactMechId;
	}

	
	public List<OrderItemDTO> getItems() { return items; }
    public void setItems(List<OrderItemDTO> items) { this.items = items; }

    
}
