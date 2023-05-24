package unimagalena.micalificacionunimag.repositories;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.api.dto.TeacherFullDTO;
import unimagalena.micalificacionunimag.api.dto.SubjectDTO;
import unimagalena.micalificacionunimag.api.dto.TeacherDTO;
import unimagalena.micalificacionunimag.api.dto.ProgramDTO;
import unimagalena.micalificacionunimag.api.dto.FacultyDTO;
import unimagalena.micalificacionunimag.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    //Clasificar con mejor tecnologia educativa y mejores resultados
    //Primera vista
    @Query(value = "SELECT p.id AS id, " +
    "CONCAT(p.first_name, ' ', p.middle_name) AS nombres, " +
    "CONCAT(p.first_last_name, ' ', p.second_last_name) AS apellidos, " +
    "pr.name AS programa, " +
    "s.name AS materia, " +
    "AVG(c.calificacion) AS calificacion " +
    "FROM persons p " +
    "JOIN teachers t ON t.user_id = p.id " +
    "JOIN teacher_programs tp ON tp.teacher_id = t.id " +
    "JOIN programs pr ON pr.id = tp.program_id " +
    "JOIN califications c ON c.teacher_id = t.id " +
    "JOIN subject_teachers st ON st.teacher_id = t.id " +
    "JOIN subjects s ON s.id = st.subject_id " +
    "WHERE s.name ILIKE CONCAT('%', :subjectName, '%') " +
    "GROUP BY p.id, pr.name, s.name", nativeQuery = true)
List<Object[]> findTeachersBySubjectName(@Param("subjectName") String subjectName);


     
    //Primera vista
    @Query(value = "SELECT p.id AS id, " +
        "CONCAT(p.first_name, ' ', p.middle_name) AS nombres, " +
        "CONCAT(p.first_last_name, ' ', p.second_last_name) AS apellidos, " +
        "pr.name AS programa, " +
        "s.name AS materia, " +
        "AVG(c.calificacion) AS calificacion " +
        "FROM persons p " +
        "JOIN teachers t ON t.user_id = p.id " +
        "JOIN teacher_programs tp ON tp.teacher_id = t.id " +
        "JOIN programs pr ON pr.id = tp.program_id " +
        "JOIN califications c ON c.teacher_id = t.id " +
        "JOIN subject_teachers st ON st.teacher_id = t.id " +
        "JOIN subjects s ON s.id = st.subject_id " +
        "WHERE (:firstName IS NULL OR p.first_name ILIKE CONCAT('%', :firstName, '%')) " +
        "AND (:middleName IS NULL OR p.middle_name ILIKE CONCAT('%', :middleName, '%')) " +
        "AND (:firstLastName IS NULL OR p.first_last_name ILIKE CONCAT('%', :firstLastName, '%')) " +
        "AND (:secondLastName IS NULL OR p.second_last_name ILIKE CONCAT('%', :secondLastName, '%')) " +
        "GROUP BY p.id, pr.name, s.name", nativeQuery = true)
List<Object[]> findByTeacherName(
        @Param("firstName") String firstName,
        @Param("middleName") String middleName,
        @Param("firstLastName") String firstLastName,
        @Param("secondLastName") String secondLastName);

    
    

    //Primera vista
    @Query(value = "SELECT p.id AS id, " +
    "CONCAT(p.first_name, ' ', p.middle_name) AS nombres, " +
    "CONCAT(p.first_last_name, ' ', p.second_last_name) AS apellidos, " +
    "pr.name AS programa, " +
    "s.name AS materia, " +
    "AVG(c.calificacion) AS calificacion " +
    "FROM persons p " +
    "JOIN teachers t ON t.user_id = p.id " +
    "JOIN teacher_programs tp ON tp.teacher_id = t.id " +
    "JOIN programs pr ON pr.id = tp.program_id " +
    "JOIN califications c ON c.teacher_id = t.id " +
    "JOIN subject_teachers st ON st.teacher_id = t.id " +
    "JOIN subjects s ON s.id = st.subject_id " +
    "WHERE pr.name ILIKE CONCAT('%', :programName, '%') " +
    "GROUP BY p.id, pr.name, s.name", nativeQuery = true)
List<Object[]> findTeachersByProgram(@Param("programName") String programName);

    
         //Primera vista
         @Query(value = "SELECT p.id AS id, " +
        "CONCAT(p.first_name, ' ', p.middle_name) AS nombres, " +
        "CONCAT(p.first_last_name, ' ', p.second_last_name) AS apellidos, " +
        "pr.name AS programa, " +
        "s.name AS materia, " +
        "AVG(c.calificacion) AS calificacion " +
        "FROM persons p " +
        "JOIN teachers t ON t.user_id = p.id " +
        "JOIN teacher_programs tp ON tp.teacher_id = t.id " +
        "JOIN programs pr ON pr.id = tp.program_id " +
        "JOIN califications c ON c.teacher_id = t.id " +
        "JOIN subject_teachers st ON st.teacher_id = t.id " +
        "JOIN subjects s ON s.id = st.subject_id " +
        "GROUP BY p.id, pr.name, s.name", nativeQuery = true)
List<Object[]> findTeachers();



         

         

         
          /*@Query(value = "SELECT new unimagalena.micalificacionunimag.api.dto.TeacherDTO(p.id, CONCAT(p.first_name, ' ', p.middle_name), CONCAT(p.first_last_name, ' ', p.second_last_name), AVG(c.calificacion)) " +
               "FROM persons p " +
               "JOIN teachers t ON t.user_id = p.id " +
               "JOIN califications c ON c.teacher_id = t.id " +
               "GROUP BY p.id")
          List<Object[]> findTeachers();
          */
         



    
    /*@Query("SELECT DISTINCT p FROM Person p JOIN p.user u JOIN u.teacher t JOIN t.programs pr WHERE pr.name = :programName")
    List<Person> findTeachersByProgram(@Param("programName") String programName);
    */

    /*@Query(value = "SELECT p.id AS id, " +
       "CONCAT(p.first_name, ' ', p.middle_name) AS nombres, " +
       "CONCAT(p.first_last_name, ' ', p.second_last_name) AS apellidos, " +
       "pr AS programas, " +
       "s AS asignaturas, " +
       "AVG(t.calificacion) AS calificacion " +
       "FROM persons p " +
       "JOIN users u ON u.person_id = p.id " +
       "JOIN programs pr ON pr.user_id = u.id " +
       "JOIN faculties f ON f.id = pr.faculty_id " +
       "JOIN teachers t ON t.user_id = u.id " +
       "JOIN subject_teachers st ON st.teacher_id = t.id " +
       "JOIN subjects s ON s.id = st.subject_id " +
       "WHERE f.name = :facultyName " +
       "GROUP BY p.id, nombres, apellidos, programas, asignaturas", nativeQuery = true)
    List<TeacherDTO> findTeachersByFaculty(@Param("facultyName") String facultyName);
    */

      //Segunda vista
      @Query(value = "SELECT p.id AS id, " +
        "CONCAT(p.first_name, ' ', p.middle_name) AS nombres, " +
        "CONCAT(p.first_last_name, ' ', p.second_last_name) AS apellidos, " +
        "pr.name AS programa, " +
        "s.name AS materia, " +
        "AVG(c.habilidad_explicacion) AS HabilidadExplicacion " +
        "FROM persons p " +
        "JOIN teachers t ON t.user_id = p.id " +
        "JOIN teacher_programs tp ON tp.teacher_id = t.id " +
        "JOIN programs pr ON pr.id = tp.program_id " +
        "JOIN califications c ON c.teacher_id = t.id " +
        "JOIN subject_teachers st ON st.teacher_id = t.id " +
        "JOIN subjects s ON s.id = st.subject_id " +
        "GROUP BY p.id, pr.name, s.name " +
        "HAVING AVG(c.habilidad_explicacion) >=4.5 " +
        "ORDER BY HabilidadExplicacion DESC", nativeQuery = true)
List<Object[]> findTeachersWithBestExplanationSkills();


      //Segunda vista
      @Query(value = "SELECT p.id AS id, " +
      "CONCAT(p.first_name, ' ', p.middle_name) AS nombres, " +
      "CONCAT(p.first_last_name, ' ', p.second_last_name) AS apellidos, " +
      "pr.name AS programa, " +
      "s.name AS materia, " +
      "AVG(c.uso_tecnologia) AS UsoTecnologia " +
         "FROM persons p " +
         "JOIN teachers t ON t.user_id = p.id " +
         "JOIN teacher_programs tp ON tp.teacher_id = t.id " +
         "JOIN programs pr ON pr.id = tp.program_id " +
         "JOIN califications c ON c.teacher_id = t.id " +
         "JOIN subject_teachers st ON st.teacher_id = t.id " +
         "JOIN subjects s ON s.id = st.subject_id " +
      "GROUP BY p.id, pr.name, s.name " +
      "HAVING AVG(c.uso_tecnologia) >=4.5 " +
      "ORDER BY UsoTecnologia DESC", nativeQuery = true)
List<Object[]> findTeachersWithBestResultsInEducationalTechnology();

@Query(value = "SELECT " +
            "AVG(c.calificacion) AS Promedio, " +
            "COUNT(DISTINCT c.student_id) AS TotalCalificaciones, " +
            "AVG(c.habilidad_explicacion) AS HabilidadExplicación, " +
            "AVG(c.metodologia_evaluacion) AS MetodologiaEvaluación, " +
            "AVG(c.trato_estudiante) AS TratoEstudiante, " +
            "AVG(c.uso_tecnologia) AS UsoTecnología, " +
            "AVG(c.metodologia) AS Metodología " +
            "FROM teachers t " +
            "JOIN califications c ON c.teacher_id = t.id " +
            "WHERE t.id = :numId", nativeQuery = true)
    List<Object[]> getTeacherStatistics(@Param("numId") Long numId);



  


    /*@Query("SELECT DISTINCT p FROM Person p JOIN p.user u JOIN u.teacher t JOIN t.programs pr JOIN pr.faculty f WHERE f.name = :facultyName")
    List<Person> findTeachersByFaculty(@Param("facultyName") String facultyName);
    */
    

    /*@Query("SELECT DISTINCT p FROM Person p " +
       "JOIN p.user u " +
       "JOIN u.teacher t " +
       "JOIN t.subjects s " +
       "JOIN t.programs pr " +
       "WHERE (:firstName IS NULL OR p.FirstName LIKE %:firstName%) " +
       "AND (:middleName IS NULL OR p.MiddleName LIKE %:middleName%) " +
       "AND (:firstLastName IS NULL OR p.FirstLastName LIKE %:firstLastName%) " +
       "AND (:secondLastName IS NULL OR p.SecondLastName LIKE %:secondLastName%) " +
       "AND (s.name = :subjectName OR :subjectName IS NULL) " +
       "AND (pr.name = :programName OR :programName IS NULL)")
    List<Person> findPersonBySubjectAndProgramAndName(@Param("subjectName") String subjectName, 
                                                @Param("programName") String programName, 
                                                @Param("firstName") String firstName,
                                                @Param("middleName") String middleName,
                                                @Param("firstLastName") String firstLastName,
                                                @Param("secondLastName") String secondLastName);
      */
                                                

      /*@Query(value = "SELECT CONCAT(s.first_name, ' ', s.middle_name, ' ', s.first_last_name, ' ', s.second_last_name) AS studentName, " +
      "CONCAT(t.first_name, ' ', t.middle_name, ' ', t.first_last_name, ' ', t.second_last_name) AS teacherName, " +
      "pub.comment AS comment " +
      "FROM persons p " +
      "JOIN users u ON u.id = p.id " +
      "LEFT JOIN students s ON s.id = u.id " +
      "LEFT JOIN teachers t ON t.id = u.id " +
      "LEFT JOIN teacher_profile_posts tp ON tp.teacher_id = t.id AND tp.student_id = s.id " +
      "LEFT JOIN publications pub ON pub.id = tp.id " +
      "WHERE t.contract_type = true " +
      "AND (:firstName IS NULL OR p.first_name LIKE %:firstName%) " +
      "AND (:middleName IS NULL OR p.middle_name LIKE %:middleName%) " +
      "AND (:firstLastName IS NULL OR p.first_last_name LIKE %:firstLastName%) " +
      "AND (:secondLastName IS NULL OR p.second_last_name LIKE %:secondLastName%) " +
      "AND (:teacherName IS NULL OR (t.first_name LIKE %:teacherName% OR t.middle_name LIKE %:teacherName% OR t.first_last_name LIKE %:teacherName% OR t.second_last_name LIKE %:teacherName%))",
      nativeQuery = true)
      List<Object[]> getTeacherComments(@Param("firstName") String firstName,
      @Param("middleName") String middleName,
      @Param("firstLastName") String firstLastName,
      @Param("secondLastName") String secondLastName,
      @Param("teacherName") String teacherName);
      */

                                                                                  
}
