package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.Person;
import unimagalena.micalificacionunimag.entities.User;
import unimagalena.micalificacionunimag.repositories.PersonRepository;
import unimagalena.micalificacionunimag.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PersonRepository personRepository;

    public UserServiceImpl(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @Override
    public User create(Long idperson, User user) {
        Person person = personRepository.findById(idperson).orElse(null);
        User copy = new User(
            idperson,
            person,
            null,
            null,
            user.getProgram(),
            user.getCode(),
            user.getEmail(),
            user.getPassword(), null
        );
        return userRepository.save(copy);
    }

    @Override
    public Optional<User> update(Long id, User user) {
        return userRepository.findById(id).map(u -> {
            u.setProgram(user.getProgram());
            u.setCode(user.getCode());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            return userRepository.save(u);
        });
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> find(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
}
