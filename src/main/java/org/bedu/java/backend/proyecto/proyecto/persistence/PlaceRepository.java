package org.bedu.java.backend.proyecto.proyecto.persistence;

import org.bedu.java.backend.proyecto.proyecto.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByOrderByNameAsc();
}
