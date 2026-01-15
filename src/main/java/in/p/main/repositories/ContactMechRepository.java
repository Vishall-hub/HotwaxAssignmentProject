package in.p.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.p.main.entities.ContactMech;

public interface ContactMechRepository extends JpaRepository<ContactMech, Integer> {
}

