package unimagalena.micalificacionunimag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    
}
