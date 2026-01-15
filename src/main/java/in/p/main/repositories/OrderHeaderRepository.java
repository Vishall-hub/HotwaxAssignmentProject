package in.p.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.p.main.entities.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Integer>{

}
