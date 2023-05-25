package unimagalena.micalificacionunimag.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.api.dto.CalificationDTO;
import unimagalena.micalificacionunimag.entities.Calification;

@Repository
public interface CalificationRepository extends JpaRepository<Calification, Long> {
    @Query(value = "SELECT " +
            "AVG(c.trato_estudiante) AS tratoEstudiante, " +
            "AVG(c.metodologia) AS metodologia, " +
            "AVG(c.metodologia_evaluacion) AS metodologiaEvaluacion, " +
            "AVG(c.habilidad_explicacion) AS explicacionClase, " +
            "AVG(c.uso_tecnologia) AS usoTecnologia, " +
            "AVG(c.calificacion) AS calificacion " +
            "FROM califications c " +
            "WHERE c.teacher_id = :teacherId " +
            "AND c.student_id = :studentId", nativeQuery = true)
    List<Object[]> getTeacherStudentStatistics(@Param("teacherId") Long teacherId, @Param("studentId") Long studentId);
}
