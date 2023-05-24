package unimagalena.micalificacionunimag.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException() {
        super("La persona asignada a ese id no se encuentra registrado.");
    }

    public PersonNotFoundException(String message) {
        super(message);
    }
    
}
