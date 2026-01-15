package in.p.repository;

import in.p.entity.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderHeader, Long> {
}
