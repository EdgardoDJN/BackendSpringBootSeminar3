package unimagalena.micalificacionunimag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    
}
