package in.p.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.p.main.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
