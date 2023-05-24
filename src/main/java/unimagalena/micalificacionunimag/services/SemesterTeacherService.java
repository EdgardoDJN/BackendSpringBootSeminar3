package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.SemesterTeacher;

public interface SemesterTeacherService {
    SemesterTeacher create(SemesterTeacher semesterTeacher);
    Optional<SemesterTeacher> update(Long id, SemesterTeacher semesterTeacher);
    List<SemesterTeacher> findAll();
    Optional<SemesterTeacher> find(Long id);
    void delete(Long id);
}
