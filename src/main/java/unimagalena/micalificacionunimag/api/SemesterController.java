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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unimagalena.micalificacionunimag.entities.Semester;
import unimagalena.micalificacionunimag.services.SemesterService;

@RestController
@RequestMapping("/api/v3")
public class SemesterController {
    @Autowired
    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping("/semesters")
    public ResponseEntity<List<Semester>> getAllSemesters()
    {
        List<Semester> semesters = semesterService.findAll();
        if(semesters.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(semesters);
        }        
    }
    @GetMapping("/semesters/{id}")
    public ResponseEntity<Optional<Semester>> getSemesterById(@PathVariable Long id)
    {
        Optional<Semester> data = semesterService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @PostMapping("/semesters")
    public ResponseEntity<Semester> createSemester(@RequestParam Semester semester)
    {
        Semester data = semesterService.create(semester);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/semesters/{id}")
    public ResponseEntity<Optional<Semester>> updateSemester(@PathVariable Long id, @RequestParam Semester semester)
    {
        Optional<Semester> data = semesterService.update(id, semester);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @DeleteMapping("/semesters/{id}")
    public ResponseEntity<String> deleteSemester(@PathVariable Long id)
    {
        semesterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Semester deleted");
    }

    
}
