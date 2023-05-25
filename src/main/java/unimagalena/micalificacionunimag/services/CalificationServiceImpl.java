package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.Calification;
import unimagalena.micalificacionunimag.entities.Student;
import unimagalena.micalificacionunimag.entities.Teacher;
import unimagalena.micalificacionunimag.repositories.CalificationRepository;
import unimagalena.micalificacionunimag.repositories.StudentRepository;
import unimagalena.micalificacionunimag.repositories.TeacherRepository;

@Service
public class CalificationServiceImpl implements CalificationService {

    @Autowired
    private final CalificationRepository calificationRepository;

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final TeacherRepository teacherRepository;

    

    public CalificationServiceImpl(CalificationRepository calificationRepository, StudentRepository studentRepository,
            TeacherRepository teacherRepository) {
        this.calificationRepository = calificationRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Calification create(Long studentId, Long teacherId,Calification calification) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        Calification copy = new Calification();
        copy.setCalificacion(calification.getCalificacion());
        copy.setTratoEstudiante(calification.getTratoEstudiante());
        copy.setMetodologia(calification.getMetodologia());
        copy.setHabilidadExplicacion(calification.getHabilidadExplicacion());
        copy.setUsoTecnologia(calification.getUsoTecnologia());
        copy.setMetodologiaEvaluacion(calification.getMetodologiaEvaluacion());
        copy.setTeacher(teacher);
        copy.setStudent(student);
        return calificationRepository.save(copy);
    }

    @Override
    public Optional<Calification> update(Long id, Calification calification) {
        return calificationRepository.findById(id).map(c -> {
            c.setCalificacion(calification.getCalificacion());
            c.setTratoEstudiante(calification.getTratoEstudiante());
            c.setMetodologia(calification.getMetodologia());
            c.setHabilidadExplicacion(calification.getHabilidadExplicacion());
            c.setUsoTecnologia(calification.getUsoTecnologia());
            c.setMetodologiaEvaluacion(calification.getMetodologiaEvaluacion());
            c.setTeacher(calification.getTeacher());
            c.setStudent(calification.getStudent());
            return calificationRepository.save(c);
        });
    }

    @Override
    public List<Calification> findAll() {
        return calificationRepository.findAll();
    }

    @Override
    public Optional<Calification> find(Long id) {
        return calificationRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        calificationRepository.deleteById(id);
    }

    @Override
    public List<Object[]> findByStudentAndTeacher(Long studentId, Long teacherId) {
        return calificationRepository.getTeacherStudentStatistics(teacherId, studentId);
    }
    
}
