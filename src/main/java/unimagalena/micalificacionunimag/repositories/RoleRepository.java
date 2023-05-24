package unimagalena.micalificacionunimag.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unimagalena.micalificacionunimag.entities.ERole;
import unimagalena.micalificacionunimag.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
