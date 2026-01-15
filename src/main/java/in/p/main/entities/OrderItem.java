package in.p.main.entities;

import jakarta.persistence.*;
	
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_seq_id")
    private int orderItemSeqId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderHeader orderHeader;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "status", nullable = false)
    private String status;

    public int getOrderItemSeqId() {
        return orderItemSeqId;
    }
    public void setOrderItemSeqId(int orderItemSeqId) {
        this.orderItemSeqId = orderItemSeqId;
    }
    public OrderHeader getOrderHeader() {
        return orderHeader;
    }
    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

