package unimagalena.micalificacionunimag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    
}
