package in.p.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.p.main.entities.ContactMech;
import in.p.main.entities.Customer;

public interface ContactMechRepository extends JpaRepository<ContactMech, Integer> {

	Optional<ContactMech> findByContactMechId(Long contactMechId);
}

