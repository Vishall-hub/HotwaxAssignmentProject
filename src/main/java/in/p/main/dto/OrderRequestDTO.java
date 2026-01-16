package in.p.main.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderRequestDTO {

	 private Long customerId;
	    private Long billingContactMechId;
	    private Long shippingContactMechId;
	    private LocalDate orderDate;
	    private String status;
	    private List<OrderItemDTO> orderItems;
		
		
		public List<OrderItemDTO> getOrderItems() {
			return orderItems;
		}
		public void setOrderItems(List<OrderItemDTO> orderItems) {
			this.orderItems = orderItems;
		}
		public Long getShippingContactMechId() {
			return shippingContactMechId;
		}
		public void setShippingContactMechId(Long shippingContactMechId) {
			this.shippingContactMechId = shippingContactMechId;
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
		
		
		public Long getBillingContactMechId() {
			return billingContactMechId;
		}
		public void setBillingContactMechId(Long billingContactMechId) {
			this.billingContactMechId = billingContactMechId;
		}
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		
		
}
