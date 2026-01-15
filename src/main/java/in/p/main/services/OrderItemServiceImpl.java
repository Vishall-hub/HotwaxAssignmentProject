package in.p.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.p.main.Dto.OrderItemRequest;
import in.p.main.entities.OrderItem;
import in.p.main.entities.OrderHeader;
import in.p.main.repositories.OrderHeaderRepository;
import in.p.main.repositories.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private OrderHeaderRepository orderRepo;

    @Override
    public OrderItem updateOrderItem(int orderId, int itemId, OrderItemRequest request) {

        OrderHeader order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderItem item = orderItemRepo.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Order item not found"));

        if (item.getOrderHeader().getOrderId() != order.getOrderId()) {
            throw new RuntimeException("Item does not belong to this order");
        }

        item.setQuantity(request.getQuantity());
        item.setStatus(request.getStatus());

        return orderItemRepo.save(item);
    }
}
