package in.p.main.services;

import java.util.List;
import in.p.main.Dto.OrderRequest;
import in.p.main.entities.OrderHeader;

public interface OrderService {

    // Create a new order
    OrderHeader createOrder(OrderRequest request);

    // Get order by ID
    OrderHeader getOrderById(int orderId);

    // Delete an order
    void deleteOrder(int orderId);

    // Get all orders
    List<OrderHeader> getAllOrders();
}
