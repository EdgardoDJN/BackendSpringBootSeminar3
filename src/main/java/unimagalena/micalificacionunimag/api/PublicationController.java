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

import unimagalena.micalificacionunimag.entities.Publication;
import unimagalena.micalificacionunimag.services.PublicationService;

@RestController
@RequestMapping("/api/v3")
public class PublicationController {
    
    @Autowired
    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/publications")
    public ResponseEntity<List<Publication>> getAllPublications()
    {
        List<Publication> publications = publicationService.findAll();
        if(publications.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(publications);
        }        
    }
    @GetMapping("/publications/{id}")
    public ResponseEntity<Optional<Publication>> getPublicationById(@PathVariable Long id)
    {
        Optional<Publication> data = publicationService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(data);
        }
    }
    @PostMapping("/publications/{id}")
    public ResponseEntity<Publication> createPublication(@PathVariable long id, @RequestBody Publication publication)
    {
        Publication data = publicationService.create(id, publication);
        return ResponseEntity.ok(data);
    }
    @PutMapping("/publications/{id}")
    public ResponseEntity<Optional<Publication>> updatePublication(@PathVariable long id, @RequestBody Publication publication)
    {
        Optional<Publication> data = publicationService.update(id, publication);
        return ResponseEntity.ok(data);
    }
    @DeleteMapping("/publications/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable long id)
    {
        publicationService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
}
