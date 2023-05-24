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

import unimagalena.micalificacionunimag.entities.Faculty;
import unimagalena.micalificacionunimag.services.FacultyService;

@RestController
@RequestMapping("/api/v3")
public class FacultyController {
    @Autowired
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/faculties")
    public ResponseEntity<List<Faculty>> getAllFaculties()
    {
        List<Faculty> faculties = facultyService.findAll();
        if(faculties.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(faculties);
        }        
    }
    @GetMapping("/faculties/{id}")
    public ResponseEntity<Optional<Faculty>> getFacultyById(@PathVariable Long id)
    {
        Optional<Faculty> data = facultyService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @PostMapping("/faculties")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty)
    {
        Faculty data = facultyService.create(faculty);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/faculties/{id}")
    public ResponseEntity<Optional<Faculty>> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty)
    {
        Optional<Faculty> data = facultyService.update(id, faculty);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok().body(data);
        }
    }
    @DeleteMapping("/faculties/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id)
    {
        facultyService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Faculty deleted");
    }
}
