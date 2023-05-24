package unimagalena.micalificacionunimag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.SemesterStudent;

@Repository
public interface SemesterStudentRepository extends JpaRepository<SemesterStudent, Long> {
    
}
