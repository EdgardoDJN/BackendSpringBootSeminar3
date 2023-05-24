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

import unimagalena.micalificacionunimag.entities.SemesterTeacher;
import unimagalena.micalificacionunimag.services.SemesterTeacherService;

@RestController
@RequestMapping("/api/v3")
public class SemesterTeacherController {
    
    @Autowired
    private final SemesterTeacherService semesterTeacherService;

    public SemesterTeacherController(SemesterTeacherService semesterTeacherService) {
        this.semesterTeacherService = semesterTeacherService;
    }

    @GetMapping("/semesterTeachers")
    public ResponseEntity<List<SemesterTeacher>> getAllSemesterTeachers()
    {
        List<SemesterTeacher> semesterTeachers = semesterTeacherService.findAll();
        if(semesterTeachers.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(semesterTeachers);
        }        
    }
    @GetMapping("/semesterTeachers/{id}")
    public ResponseEntity<Optional<SemesterTeacher>> getSemesterTeacherById(@PathVariable Long id)
    {
        Optional<SemesterTeacher> data = semesterTeacherService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @PostMapping("/semesterTeachers/{id}")
    public ResponseEntity<SemesterTeacher> createSemesterTeacher(@RequestBody SemesterTeacher semesterTeacher)
    {
        SemesterTeacher data = semesterTeacherService.create(semesterTeacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/semesterTeachers/{id}")
    public ResponseEntity<Optional<SemesterTeacher>> updateSemesterTeacher(@PathVariable Long id, SemesterTeacher semesterTeacher)
    {
        Optional<SemesterTeacher> data = semesterTeacherService.update(id, semesterTeacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @DeleteMapping("/semesterTeachers/{id}")
    public ResponseEntity<String> deleteSemesterTeacher(@PathVariable Long id)
    {
        semesterTeacherService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
}
