package in.p.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import in.p.main.Dto.OrderRequest;
import in.p.main.entities.OrderHeader;
import in.p.main.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Create a new order
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request) {
        try {
            OrderHeader order = orderService.createOrder(request);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        try {
            List<OrderHeader> orders = orderService.getAllOrders();
            return ResponseEntity.ok(orders);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    // Get single order by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable int id) {
        try {
            OrderHeader order = orderService.getOrderById(id);
            return ResponseEntity.ok(order);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", ex.getMessage()));
        }
    }
}
