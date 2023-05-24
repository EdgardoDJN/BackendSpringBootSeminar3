package unimagalena.micalificacionunimag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.Calification;

@Repository
public interface CalificationRepository extends JpaRepository<Calification, Long> {
    
}
