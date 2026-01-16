package in.p.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.p.main.entities.OrderHeader;
import in.p.main.entities.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // This method will allow finding an OrderItem by its ID and order ID
	// Correct if OrderHeader has orderId
	List<OrderItem> findByOrder(OrderHeader order);

    void deleteByOrder(OrderHeader order);

}
