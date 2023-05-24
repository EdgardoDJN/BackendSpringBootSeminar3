package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.SemesterStudent;

public interface SemesterStudentService {
    SemesterStudent create(SemesterStudent semesterStudent);
    Optional<SemesterStudent> update(Long id, SemesterStudent semesterStudent);
    List<SemesterStudent> findAll();
    Optional<SemesterStudent> find(Long id);
    void delete(Long id);
}
