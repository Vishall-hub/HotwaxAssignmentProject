package in.p.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.p.main.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
