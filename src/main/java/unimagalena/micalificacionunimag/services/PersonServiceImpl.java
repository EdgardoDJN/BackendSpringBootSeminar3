package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.Person;
import unimagalena.micalificacionunimag.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(Person person) {
        Person copy = new Person(
            null,
            null,
            person.getFirstName(),
            person.getMiddleName(),
            person.getFirstLastName(),
            person.getSecondLastName()
        );
        return personRepository.save(copy);
    }

    @Override
    public Optional<Person> update(Long id, Person person) {
        return personRepository.findById(id).map(p -> {
            p.setFirstName(person.getFirstName());
            p.setMiddleName(person.getMiddleName());
            p.setFirstLastName(person.getFirstLastName());
            p.setSecondLastName(person.getSecondLastName());
            return personRepository.save(p);
        });
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> find(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
    
}
