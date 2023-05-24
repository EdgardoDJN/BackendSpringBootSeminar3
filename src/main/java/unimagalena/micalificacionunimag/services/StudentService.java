package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.Student;

public interface StudentService {
    Student create(Long iduser, Student student);
    Optional<Student> update(Long id, Student student);
    List<Student> findAll();
    Optional<Student> find(Long id);
    void delete(Long id);
}
