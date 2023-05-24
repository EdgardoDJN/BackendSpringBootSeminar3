package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.api.dto.TeacherDTO;
import unimagalena.micalificacionunimag.api.dto.TeacherFullDTO;
import unimagalena.micalificacionunimag.entities.Teacher;

public interface TeacherService {
    Teacher create(Long iduser, Teacher teacher);
    Optional<Teacher> update(Long id, Teacher teacher);
    List<Teacher> findAll();
    List<Object[]> findTeachersBySubjectName(String subjectName);
    List<Object[]> findByTeacherName(String firstName, String middleName, String firstLastName, String secondLastName);
    List<Object[]> findTeachersByProgram(String programName);
    List<Object[]> findTeachers();
    List<Object[]> findTeachersWithBestResults();
    List<Object[]> findTeachersWithBestResultsInEducationalTecnology();
    List<Object[]> getTeacherStatistics(Long id);
    Optional<Teacher> find(Long id);
    void delete(Long id);
}
