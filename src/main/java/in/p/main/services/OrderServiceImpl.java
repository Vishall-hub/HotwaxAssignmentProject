package in.p.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.p.main.Dto.OrderItemRequest;
import in.p.main.Dto.OrderRequest;
import in.p.main.entities.*;
import in.p.main.repositories.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderHeaderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ContactMechRepository contactRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Override
    public OrderHeader createOrder(OrderRequest request) {

        // Validate Customer
        Customer customer = customerRepo.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + request.getCustomerId()));

        // Validate Shipping & Billing Contact
        ContactMech shipping = contactRepo.findById(request.getShippingContactMechId())
                .orElseThrow(() -> new RuntimeException("Shipping Contact not found with id: " + request.getShippingContactMechId()));

        ContactMech billing = contactRepo.findById(request.getBillingContactMechId())
                .orElseThrow(() -> new RuntimeException("Billing Contact not found with id: " + request.getBillingContactMechId()));

        // Create OrderHeader
        OrderHeader order = new OrderHeader();
        order.setOrderDate(request.getOrderDate());
        order.setCustomer(customer);
        order.setShippingContactMech(shipping);
        order.setBillingContactMech(billing);

        orderRepository.save(order);

        // Create OrderItems
        for (OrderItemRequest itemReq : request.getItems()) {
            Product product = productRepo.findById(itemReq.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemReq.getProductId()));

            OrderItem item = new OrderItem();
            item.setOrderHeader(order);
            item.setProduct(product);
            item.setQuantity(itemReq.getQuantity());
            item.setStatus(itemReq.getStatus());

            orderItemRepo.save(item);
        }

        return order;
    }

    @Override
    public OrderHeader getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    @Override
    public void deleteOrder(int orderId) {
        OrderHeader order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        orderRepository.delete(order);
    }

    // ✅ NEW METHOD: Get all orders
    @Override
    public List<OrderHeader> getAllOrders() {
        return orderRepository.findAll();
    }
}
