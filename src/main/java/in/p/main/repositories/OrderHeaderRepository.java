package in.p.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.p.main.entities.Customer;
import in.p.main.entities.OrderHeader;
@Repository
public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long>{

	
	List<OrderHeader> findAllByCustomerCustomerId(Long customerId);

	// Optional: Get the first order (if you want to return one order)
	Optional<OrderHeader> findFirstByCustomerCustomerId(Long customerId);

	
	
}
