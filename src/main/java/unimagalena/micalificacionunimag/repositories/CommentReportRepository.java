package unimagalena.micalificacionunimag.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.CommentReport;

@Repository
public interface CommentReportRepository extends JpaRepository<CommentReport, Long> {
    
}
