package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.Person;

public interface PersonService {
    Person create(Person person);
    Optional<Person> update(Long id, Person person);
    List<Person> findAll();
    Optional<Person> find(Long id);
    void delete(Long id);
}
