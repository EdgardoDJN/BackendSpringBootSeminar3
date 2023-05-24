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

import unimagalena.micalificacionunimag.entities.Subject;
import unimagalena.micalificacionunimag.services.SubjectService;

@RestController
@RequestMapping("/api/v3")
public class SubjectController {
    
    @Autowired
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects()
    {
        List<Subject> subjects = subjectService.findAll();
        if(subjects.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(subjects);
        }        
    }
    @GetMapping("/subjects/{id}")
    public ResponseEntity<Optional<Subject>> getSubjectById(@PathVariable Long id)
    {
        Optional<Subject> data = subjectService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @PostMapping("/subjects")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject)
    {
        Subject data = subjectService.create(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/subjects/{id}")
    public ResponseEntity<Optional<Subject>> updateSubject(@RequestBody Subject subject, @PathVariable Long id)
    {
        Optional<Subject> data = subjectService.update(id, subject);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else{
            return ResponseEntity.status(HttpStatus.CREATED).body(data);
        }
    }
    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long id)
    {
        subjectService.delete(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deleted");
    }
}
