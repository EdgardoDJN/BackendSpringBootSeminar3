package unimagalena.micalificacionunimag.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unimagalena.micalificacionunimag.api.dto.CalificationDTO;
import unimagalena.micalificacionunimag.api.dto.CalificationMapper;
import unimagalena.micalificacionunimag.entities.Calification;
import unimagalena.micalificacionunimag.services.CalificationService;

@RestController
@RequestMapping("/api/v3")
public class CalificationController {
    
    @Autowired
    private final CalificationService calificationService;

    public CalificationController(CalificationService calificationService) {
        this.calificationService = calificationService;
    }

    @GetMapping("/califications")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<List<CalificationDTO>> getAllCalifications()
    {
        List<Calification> califications = calificationService.findAll(); 
        if(califications.isEmpty())
            return ResponseEntity.noContent().build();
        else{
            List<CalificationDTO> dto = CalificationMapper.toCalificationDTOs(califications);    
            return ResponseEntity.ok(dto);
        }   
    }
    @GetMapping("/califications/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<CalificationDTO> getCalificationById(@PathVariable Long id)
    {
        Optional<Calification> calification = calificationService.find(id);
        if(calification.isEmpty())
            return ResponseEntity.noContent().build();
        else{
            CalificationDTO dto = CalificationMapper.toCalificationDTO(calification.get());
            return ResponseEntity.ok(dto);
        }
    }
    @PostMapping("/califications/student/{studentId}/teacher/{teacherId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<String> createCalification(@PathVariable Long studentId, @PathVariable Long teacherId, @RequestBody CalificationDTO calificationDTO)
    {
        Calification toCalification = CalificationMapper.toCalification(calificationDTO);
        Calification data = calificationService.create(studentId, teacherId, toCalification);
        return ResponseEntity.status(HttpStatus.CREATED).body("Calification created");
    }

    @PutMapping("/califications/{id}")
    public ResponseEntity<Optional<Calification>> updateCalification(@PathVariable Long id, @RequestBody Calification calification)
    {
        Optional<Calification> data = calificationService.update(id, calification);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(data);
        }
    }
    @DeleteMapping("/califications/{id}")
    public ResponseEntity<String> deleteCalification(@PathVariable Long id)
    {
        calificationService.delete(id);
        return ResponseEntity.ok("Calification deleted");
    }
}
