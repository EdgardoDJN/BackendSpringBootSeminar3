package unimagalena.micalificacionunimag.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unimagalena.micalificacionunimag.entities.Student;
import unimagalena.micalificacionunimag.services.StudentService;

@RestController
@RequestMapping("/api/v3")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents()
    {
        List<Student> students = studentService.findAll();
        if(students.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(students);
        }        
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id)
    {
        Optional<Student> data = studentService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @PostMapping("/students/{id}")
    public ResponseEntity<Student> createStudent(@PathVariable Long id, @RequestBody Student student)
    {
        Student data = studentService.create(id, student);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, Student student)
    {
        Optional<Student> data = studentService.update(id, student);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(data.get());
        }
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted");
    }
}
