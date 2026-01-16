package in.p.main.service;

import in.p.main.dto.*;
import in.p.main.entities.*;
import in.p.main.repositories.*;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderHeaderRepository orderRepo;
    private final OrderItemRepository itemRepo;
    private final CustomerRepository customerRepo;
    private final ContactMechRepository contactRepo;

    public OrderService(OrderHeaderRepository orderRepo,
                        OrderItemRepository itemRepo,
                        CustomerRepository customerRepo,
                        ContactMechRepository contactRepo) {
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo;
        this.customerRepo = customerRepo;
        this.contactRepo = contactRepo;
    }

    // -------------------------
    // CREATE ORDER
    // -------------------------
    public OrderResponseDTO createOrder(OrderRequestDTO dto) {

        OrderHeader order = new OrderHeader();
        order.setOrderDate(dto.getOrderDate());
        order.setStatus(dto.getStatus());

        order.setCustomer(customerRepo.findByCustomerId(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found")));

        order.setBillingContactMech(contactRepo.findByContactMechId(dto.getBillingContactMechId())
                .orElseThrow(() -> new RuntimeException("Billing Contact not found")));

        order.setShippingContactMech(contactRepo.findByContactMechId(dto.getShippingContactMechId())
                .orElseThrow(() -> new RuntimeException("Shipping Contact not found")));

        // Save order first
        OrderHeader savedOrder = orderRepo.save(order);

        // Save items after order exists
        if (dto.getOrderItems() != null) {
            for (OrderItemDTO itemDTO : dto.getOrderItems()) {
                OrderItem item = new OrderItem();
                item.setProductName(itemDTO.getProductName());
                item.setQuantity(itemDTO.getQuantity());
                item.setUnitPrice(itemDTO.getUnitPrice());
                item.setOrder(savedOrder);
                itemRepo.save(item);
            }
        }

        return mapToResponse(savedOrder);
    }

    // -------------------------
    // GET ORDER BY ID
    // -------------------------
    public OrderResponseDTO getOrder(Long id) {
        OrderHeader order = orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return mapToResponse(order);
    }

    // -------------------------
    // GET ALL ORDERS
    // -------------------------
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // -------------------------
    // GET ALL ORDERS BY CUSTOMER
    // -------------------------
    public List<OrderResponseDTO> getOrdersByCustomer(Long customerId) {
        return orderRepo.findAllByCustomerCustomerId(customerId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // -------------------------
    // UPDATE ORDER
    // -------------------------
    public OrderResponseDTO updateOrder(Long id, OrderRequestDTO dto) {

        OrderHeader order = orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setOrderDate(dto.getOrderDate());
        order.setStatus(dto.getStatus());

        order.setCustomer(customerRepo.findByCustomerId(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found")));

        order.setBillingContactMech(contactRepo.findByContactMechId(dto.getBillingContactMechId())
                .orElseThrow(() -> new RuntimeException("Billing Contact not found")));

        order.setShippingContactMech(contactRepo.findByContactMechId(dto.getShippingContactMechId())
                .orElseThrow(() -> new RuntimeException("Shipping Contact not found")));

        return mapToResponse(orderRepo.save(order));
    }

    // -------------------------
    // DELETE ORDER
    // -------------------------
    @Transactional
    public void deleteOrder(Long orderId) {
        OrderHeader order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        itemRepo.deleteByOrder(order);
        orderRepo.delete(order);
    }

    // -------------------------
    // ADD ITEM TO ORDER
    // -------------------------
    public OrderItemDTO addItem(Long orderId, OrderItemDTO dto) {

        OrderHeader order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderItem item = new OrderItem();
        item.setProductName(dto.getProductName());
        item.setQuantity(dto.getQuantity());
        item.setUnitPrice(dto.getUnitPrice());
        item.setOrder(order);

        return mapItem(itemRepo.save(item));
    }

    // -------------------------
    // GET ITEMS OF ORDER
    // -------------------------
    public List<OrderItemDTO> getItems(Long orderId) {
        OrderHeader order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return itemRepo.findByOrder(order)
                .stream()
                .map(this::mapItem)
                .collect(Collectors.toList());
    }

    // -------------------------
    // MAPPERS
    // -------------------------
    private OrderResponseDTO mapToResponse(OrderHeader order) {

        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getOrderId());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setCustomerId(order.getCustomer().getCustomerId());

        dto.setBillingContactMechId(order.getBillingContactMech().getContactMechId());
        dto.setShippingContactMechId(order.getShippingContactMech().getContactMechId());

        dto.setItems(itemRepo.findByOrder(order)
                .stream()
                .map(this::mapItem)
                .collect(Collectors.toList())
        );

        return dto;
    }

    private OrderItemDTO mapItem(OrderItem item) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setOrderItemId(item.getOrderItemId());
        dto.setProductName(item.getProductName());
        dto.setQuantity(item.getQuantity());
        dto.setUnitPrice(item.getUnitPrice());
        return dto;
    }
}
