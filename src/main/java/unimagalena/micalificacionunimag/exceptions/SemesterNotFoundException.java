package unimagalena.micalificacionunimag.exceptions;

public class SemesterNotFoundException extends RuntimeException {
    
    public SemesterNotFoundException() {
        super("El semestre asignado a ese id no se encuentra registrado.");
    }

    public SemesterNotFoundException(String message) {
        super(message);
    }
}
