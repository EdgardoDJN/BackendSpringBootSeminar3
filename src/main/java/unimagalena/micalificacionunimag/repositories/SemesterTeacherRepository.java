package unimagalena.micalificacionunimag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.SemesterTeacher;

@Repository
public interface SemesterTeacherRepository extends JpaRepository<SemesterTeacher, Long> {
    
}
