package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.Semester;
import unimagalena.micalificacionunimag.repositories.SemesterRepository;

@Service
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    private final SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Override
    public Semester create(Semester semester) {
        Semester copy = new Semester(null, semester.getInitialDate(), null, null);
        return semesterRepository.save(copy);
    }

    @Override
    public Optional<Semester> update(Long id, Semester semester) {
        return semesterRepository.findById(id).map(s -> {
            s.setInitialDate(semester.getInitialDate());
            return semesterRepository.save(s);
        });
    }

    @Override
    public List<Semester> findAll() {
        return semesterRepository.findAll();
    }

    @Override
    public Optional<Semester> find(Long id) {
        return semesterRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        semesterRepository.deleteById(id);
    }
    
}
