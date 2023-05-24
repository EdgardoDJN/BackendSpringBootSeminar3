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

import unimagalena.micalificacionunimag.entities.Person;
import unimagalena.micalificacionunimag.services.PersonService;

@RestController
@RequestMapping("/api/v3")
public class PersonController {
    
    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons()
    {
        List<Person> persons = personService.findAll();
        if(persons.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(persons);
        }        
    }
    @GetMapping("/persons/{id}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable Long id)
    {
        Optional<Person> data = personService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person)
    {
        Person data = personService.create(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/persons/{id}")
    public ResponseEntity<Optional<Person>> updatePerson(@PathVariable Long id, @RequestBody Person person)
    {
        Optional<Person> data = personService.update(id, person);
        return ResponseEntity.ok(data);
    }
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id)
    {
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Person deleted");
    } 
}
