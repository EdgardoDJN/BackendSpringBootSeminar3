package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.api.dto.TeacherDTO;
import unimagalena.micalificacionunimag.api.dto.TeacherFullDTO;
import unimagalena.micalificacionunimag.entities.Teacher;
import unimagalena.micalificacionunimag.entities.User;
import unimagalena.micalificacionunimag.repositories.TeacherRepository;
import unimagalena.micalificacionunimag.repositories.UserRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private final TeacherRepository teacherRepository;

    @Autowired
    private final UserRepository userRepository;

    
    public TeacherServiceImpl(TeacherRepository teacherRepository, UserRepository userRepository) {
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Teacher create(Long iduser, Teacher teacher) {
        User user = userRepository.findById(iduser).orElse(null);
        Teacher copy = new Teacher(
            iduser,
            user,
            teacher.getContractType(),
            teacher.getPrograms(),
            null,
            null,
            null,
            null, null
        );
        return teacherRepository.save(copy);
    }

    @Override
    public Optional<Teacher> update(Long id, Teacher teacher) {
        return teacherRepository.findById(id).map(t -> {
            t.setContractType(teacher.getContractType());
            t.setPrograms(teacher.getPrograms());
            return teacherRepository.save(t);
        });
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> find(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Object[]> findTeachersBySubjectName(String subjectName) {
        return teacherRepository.findTeachersBySubjectName(subjectName);
    }

    @Override
    public List<Object[]> findByTeacherName(String firstName, String middleName, String firstLastName,
            String secondLastName) {
       return teacherRepository.findByTeacherName(firstName, middleName, firstLastName, secondLastName);
    }

    @Override
    public List<Object[]> findTeachersByProgram(String programName) {
        return teacherRepository.findTeachersByProgram(programName);
    }

    @Override
    public List<Object[]> findTeachers() {
        return teacherRepository.findTeachers();
    }

    @Override
    public List<Object[]> findTeachersWithBestResults() {
        return teacherRepository.findTeachersWithBestExplanationSkills();
    }

    @Override
    public List<Object[]> findTeachersWithBestResultsInEducationalTecnology() {
        return teacherRepository.findTeachersWithBestResultsInEducationalTechnology();
    }

    @Override
    public List<Object[]> getTeacherStatistics(Long id) {
        return teacherRepository.getTeacherStatistics(id);
    }
    
}
