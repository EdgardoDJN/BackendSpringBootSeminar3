package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.Calification;

public interface CalificationService {
    Calification create(Long studentId, Long teacherId, Calification calification);
    Optional<Calification> update(Long id, Calification calification);
    List<Calification> findAll();
    Optional<Calification> find(Long id);
    void delete(Long id);
}
