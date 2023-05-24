package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.Program;

public interface ProgramService {
    Program create(Program program);
    Optional<Program> update(Long id, Program program);
    List<Program> findAll();
    Optional<Program> find(Long id);
    void delete(Long id);
}
