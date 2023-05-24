package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.SemesterStudent;
import unimagalena.micalificacionunimag.repositories.SemesterStudentRepository;

@Service
public class SemesterStudentServiceImpl implements SemesterStudentService {

    @Autowired
    private final SemesterStudentRepository semesterStudentRepository;

    public SemesterStudentServiceImpl(SemesterStudentRepository semesterStudentRepository) {
        this.semesterStudentRepository = semesterStudentRepository;
    }

    @Override
    public SemesterStudent create(SemesterStudent semesterStudent) {
        SemesterStudent copy = new SemesterStudent(
            null,
            semesterStudent.getSemester(),
            semesterStudent.getStudent(),
            semesterStudent.getSemesterNumber(), 
            null
        );
        return semesterStudentRepository.save(copy);
    }

    @Override
    public Optional<SemesterStudent> update(Long id, SemesterStudent semesterStudent) {
        return semesterStudentRepository.findById(id).map(ss -> {
            ss.setSemester(semesterStudent.getSemester());
            ss.setStudent(semesterStudent.getStudent());
            ss.setSemesterNumber(semesterStudent.getSemesterNumber());
            return semesterStudentRepository.save(ss);
        });
    }

    @Override
    public List<SemesterStudent> findAll() {
        return semesterStudentRepository.findAll();
    }

    @Override
    public Optional<SemesterStudent> find(Long id) {
        return semesterStudentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        semesterStudentRepository.deleteById(id);
    }
    
}
