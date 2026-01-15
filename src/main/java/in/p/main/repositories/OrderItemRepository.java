package in.p.main.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import in.p.main.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    // This method will allow finding an OrderItem by its ID and order ID
    Optional<OrderItem> findByOrderItemSeqIdAndOrderHeader_OrderId(
            int orderItemSeqId,
            int orderId
    );
}
