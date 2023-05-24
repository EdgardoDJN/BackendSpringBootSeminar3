package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.Semester;

public interface SemesterService {
    Semester create(Semester semester);
    Optional<Semester> update(Long id, Semester semester);
    List<Semester> findAll();
    Optional<Semester> find(Long id);
    void delete(Long id);
}
