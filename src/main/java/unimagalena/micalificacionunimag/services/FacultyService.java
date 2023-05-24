package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.Faculty;

public interface FacultyService {
    Faculty create(Faculty person);
    Optional<Faculty> update(Long id, Faculty faculty);
    List<Faculty> findAll();
    Optional<Faculty> find(Long id);
    void delete(Long id);
}
