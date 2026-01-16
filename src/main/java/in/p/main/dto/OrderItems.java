package in.p.main.dto;

import java.util.List;

public class OrderItems {
	private Long orderId;
    private String customerName;
    private List<OrderItemDTO> orderItems; // ✅ Must be List

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItemDTO> getOrderItems() { // ✅ Must return List
        return orderItems;
    }
    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

}
