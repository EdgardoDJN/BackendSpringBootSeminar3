package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.Student;
import unimagalena.micalificacionunimag.entities.User;
import unimagalena.micalificacionunimag.repositories.StudentRepository;
import unimagalena.micalificacionunimag.repositories.UserRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final UserRepository userRepository;

    

    public StudentServiceImpl(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Student create(Long iduser, Student student) {
        User user = userRepository.findById(iduser).orElse(null);
        Student copy = new Student(
            iduser,
            user,
            student.getRegistered(),
            null,
            null, null
        );
        return studentRepository.save(copy);
    }

    @Override
    public Optional<Student> update(Long id, Student student) {
        return studentRepository.findById(id).map(s -> {
            s.setRegistered(student.getRegistered());
            return studentRepository.save(s);
        });
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> find(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
    
}
