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

import unimagalena.micalificacionunimag.entities.Program;
import unimagalena.micalificacionunimag.services.ProgramService;

@RestController
@RequestMapping("/api/v3")
public class ProgramController {
    @Autowired
    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/programs")
    public ResponseEntity<List<Program>> getAllPrograms()
    {
        List<Program> programs = programService.findAll();
        if(programs.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(programs);
        }        
    }
    @GetMapping("/programs/{id}")
    public ResponseEntity<Optional<Program>> getProgramById(@PathVariable Long id)
    {
        Optional<Program> data = programService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @PostMapping("/programs")
    public ResponseEntity<Program> createProgram(@RequestBody Program program)
    {
        Program data = programService.create(program);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/programs/{id}")
    public ResponseEntity<Optional<Program>> updateProgram(@PathVariable Long id, @RequestBody Program program)
    {
        Optional<Program> data = programService.update(id, program);
        return ResponseEntity.ok(data);
    }
    @DeleteMapping("/programs/{id}")
    public ResponseEntity<String> deleteProgram(@PathVariable Long id)
    {
        programService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Program deleted");
    }
}
