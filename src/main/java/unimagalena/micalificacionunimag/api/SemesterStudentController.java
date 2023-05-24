package unimagalena.micalificacionunimag.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unimagalena.micalificacionunimag.entities.SemesterStudent;
import unimagalena.micalificacionunimag.services.SemesterStudentService;

@RestController
@RequestMapping("/api/v3")
public class SemesterStudentController {
    
    @Autowired
    private final SemesterStudentService semesterStudentService;

    public SemesterStudentController(SemesterStudentService semesterStudentService) {
        this.semesterStudentService = semesterStudentService;
    }

    @GetMapping("/semesterStudents")
    public ResponseEntity<List<SemesterStudent>> getAllSemesterStudents()
    {
        List<SemesterStudent> semesterStudents = semesterStudentService.findAll();
        if(semesterStudents.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(semesterStudents);
        }        
    }
    @GetMapping("/semesterStudents/{id}")
    public ResponseEntity<Optional<SemesterStudent>> getSemesterStudentById(@PathVariable Long id)
    {
        Optional<SemesterStudent> data = semesterStudentService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @PostMapping("/semesterStudents")
    public ResponseEntity<SemesterStudent> createSemesterStudent(@RequestBody SemesterStudent semesterStudent)
    {
        SemesterStudent data = semesterStudentService.create(semesterStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/semesterStudents/{id}")
    public ResponseEntity<Optional<SemesterStudent>> updateSemesterStudent(@RequestBody SemesterStudent semesterStudent, @PathVariable Long id)
    {
        Optional<SemesterStudent> data = semesterStudentService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            Optional<SemesterStudent> updated = semesterStudentService.update(id, semesterStudent);
            return ResponseEntity.status(HttpStatus.CREATED).body(updated);
        }
    }
    @DeleteMapping("/semesterStudents/{id}")
    public ResponseEntity<String> deleteSemesterStudent(@PathVariable Long id)
    {
            semesterStudentService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("SemesterStudent deleted");
    }
}
