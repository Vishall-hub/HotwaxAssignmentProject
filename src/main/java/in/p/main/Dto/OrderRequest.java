package in.p.main.Dto;

import java.time.LocalDate;
import java.util.List;

public class OrderRequest {

    private LocalDate orderDate;
    private int customerId;
    private int shippingContactMechId;
    private int billingContactMechId;
    private List<OrderItemRequest> items;

    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getShippingContactMechId() {
        return shippingContactMechId;
    }
    public void setShippingContactMechId(int shippingContactMechId) {
        this.shippingContactMechId = shippingContactMechId;
    }
    public int getBillingContactMechId() {
        return billingContactMechId;
    }
    public void setBillingContactMechId(int billingContactMechId) {
        this.billingContactMechId = billingContactMechId;
    }
    public List<OrderItemRequest> getItems() {
        return items;
    }
    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
