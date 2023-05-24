package unimagalena.micalificacionunimag.exceptions;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException() {
        super("El usuario asignado a ese id no se encuentra registrado.");
    }
    public UserNotFoundException(String message) {
        super(message);
    }
}
