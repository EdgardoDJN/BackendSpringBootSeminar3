package unimagalena.micalificacionunimag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.TeacherProfilePost;

@Repository
public interface TeacherProfilePostRepository extends JpaRepository<TeacherProfilePost, Long> {
    
}
