package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.Faculty;
import unimagalena.micalificacionunimag.repositories.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty create(Faculty faculty) {
        Faculty copy = new Faculty(
            null,
            faculty.getName(),
            null
        );
        return facultyRepository.save(copy);
    }

    @Override
    public Optional<Faculty> update(Long id, Faculty faculty) {
        return facultyRepository.findById(id).map(f -> {
            f.setName(faculty.getName());
            return facultyRepository.save(f);
        });
    }

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Optional<Faculty> find(Long id) {
        return facultyRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }
    
}
