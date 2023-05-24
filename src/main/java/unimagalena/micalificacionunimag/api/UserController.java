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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import unimagalena.micalificacionunimag.api.dto.UserDTO;
import unimagalena.micalificacionunimag.api.dto.UserMapper;
import unimagalena.micalificacionunimag.entities.User;
import unimagalena.micalificacionunimag.services.UserService;

@RestController
@RequestMapping("/api/v3")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.findAll();
        if(users.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(users);
        }        
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id)
    {
        Optional<User> data = userService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @GetMapping("/users/email")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam(required = true) String email)
    {
        Optional<User> data = userService.findByEmail(email);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            UserDTO userEmail = UserMapper.toEmailDTO(data.get());
            return ResponseEntity.status(HttpStatus.FOUND).body(userEmail);
        }
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<User> createUser(@PathVariable Long id, @RequestBody User user)
    {
        User data = userService.create(id, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable Long id, @RequestBody User user)
    {
        Optional<User> data = userService.update(id, user);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(data);
        }
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
    }
}
