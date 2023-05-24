package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.User;


public interface UserService {
    User create(Long idperson, User user);
    Optional<User> update(Long id, User user);
    List<User> findAll();
    Optional<User> find(Long id);
    void delete(Long id);
    Optional<User> findByEmail(String email);
}
