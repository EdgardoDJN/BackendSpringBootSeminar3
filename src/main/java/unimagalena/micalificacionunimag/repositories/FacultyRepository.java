package unimagalena.micalificacionunimag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    
}
