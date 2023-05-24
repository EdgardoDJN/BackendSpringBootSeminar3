package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.Program;
import unimagalena.micalificacionunimag.repositories.ProgramRepository;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program create(Program program) {
        Program copy = new Program(
            null,
            null,
            program.getFaculty(),
            program.getName(),
            null
        );
        return programRepository.save(copy);
    }

    @Override
    public Optional<Program> update(Long id, Program program) {
        return programRepository.findById(id).map(p -> {
            p.setFaculty(program.getFaculty());
            p.setName(program.getName());
            return programRepository.save(p);
        });
    }

    @Override
    public List<Program> findAll() {
        return programRepository.findAll();
    }

    @Override
    public Optional<Program> find(Long id) {
        return programRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        programRepository.deleteById(id);
    }
    
}
