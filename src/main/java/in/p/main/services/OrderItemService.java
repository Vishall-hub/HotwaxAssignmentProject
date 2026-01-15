package in.p.main.services;

import in.p.main.Dto.OrderItemRequest;
import in.p.main.entities.OrderItem;

public interface OrderItemService {

    OrderItem updateOrderItem(int orderId, int itemId, OrderItemRequest request);
}
