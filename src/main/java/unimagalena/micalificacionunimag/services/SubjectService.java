package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.Subject;

public interface SubjectService {
    Subject create(Subject subject);
    Optional<Subject> update(Long id, Subject subject);
    List<Subject> findAll();
    Optional<Subject> find(Long id);
    void delete(Long id);
}
