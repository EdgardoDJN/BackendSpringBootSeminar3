package unimagalena.micalificacionunimag.exceptions;

public class FacultyNotFoundException extends RuntimeException {

    public FacultyNotFoundException() {
        super("La facultad asignada a ese id no se encuentra registrado.");
    }

    public FacultyNotFoundException(String message) {
        super(message);
    }
    
}
