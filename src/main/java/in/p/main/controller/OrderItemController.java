package in.p.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.p.main.Dto.OrderItemRequest;
import in.p.main.entities.OrderItem;
import in.p.main.services.OrderItemService;

@RestController
@RequestMapping("/orders/{orderId}/items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    // UPDATE ORDER ITEM
    @PutMapping("/{itemId}")
    public ResponseEntity<OrderItem> updateOrderItem(
            @PathVariable int orderId,
            @PathVariable int itemId,
            @RequestBody OrderItemRequest request) {

        OrderItem updatedItem =
                orderItemService.updateOrderItem(orderId, itemId, request);

        return ResponseEntity.ok(updatedItem);
    }
}
