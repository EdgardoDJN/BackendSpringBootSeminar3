package unimagalena.micalificacionunimag.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
        super("El estudiante asignado a ese id no se encuentra registrado.");
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
    
}
