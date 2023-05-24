package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.SemesterTeacher;
import unimagalena.micalificacionunimag.repositories.SemesterTeacherRepository;

@Service
public class SemesterTeacherServiceImpl implements SemesterTeacherService {

    @Autowired
    private final SemesterTeacherRepository semesterTeacherRepository;

    public SemesterTeacherServiceImpl(SemesterTeacherRepository semesterTeacherRepository) {
        this.semesterTeacherRepository = semesterTeacherRepository;
    }

    @Override
    public SemesterTeacher create(SemesterTeacher semesterTeacher) {
        SemesterTeacher copy = new SemesterTeacher(
            null,
            semesterTeacher.getTeacher(),
            semesterTeacher.getSemester(),
            semesterTeacher.getTeachers()
        );
        return semesterTeacherRepository.save(copy);
    }

    @Override
    public Optional<SemesterTeacher> update(Long id, SemesterTeacher semesterTeacher) {
        return semesterTeacherRepository.findById(id).map(st -> {
            st.setTeacher(semesterTeacher.getTeacher());
            st.setSemester(semesterTeacher.getSemester());
            st.setTeachers(semesterTeacher.getTeachers());
            return semesterTeacherRepository.save(st);
        });
    }

    @Override
    public List<SemesterTeacher> findAll() {
        return semesterTeacherRepository.findAll();
    }

    @Override
    public Optional<SemesterTeacher> find(Long id) {
        return semesterTeacherRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        semesterTeacherRepository.deleteById(id);
    }
    
}
