package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.Subject;
import unimagalena.micalificacionunimag.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject create(Subject subject) {
        Subject copy = new Subject(
            null,
            subject.getName(),
            subject.getDescription(),
            subject.getMandatory(),
            subject.getGender(),
            subject.getSemesterStudents(),
            subject.getTeachers()
        );
        return subjectRepository.save(copy);
    }

    @Override
    public Optional<Subject> update(Long id, Subject subject) {
        return subjectRepository.findById(id).map(s -> {
            s.setName(subject.getName());
            s.setDescription(subject.getDescription());
            s.setMandatory(subject.getMandatory());
            s.setGender(subject.getGender());
            s.setSemesterStudents(subject.getSemesterStudents());
            s.setTeachers(subject.getTeachers());
            return subjectRepository.save(s);
        });
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> find(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
    
}
