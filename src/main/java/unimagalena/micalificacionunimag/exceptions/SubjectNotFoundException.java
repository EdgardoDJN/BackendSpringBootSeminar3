package unimagalena.micalificacionunimag.exceptions;

public class SubjectNotFoundException extends RuntimeException {
    
    public SubjectNotFoundException() {
        super("La materia asignada a ese id no se encuentra registrado.");
    }

    public SubjectNotFoundException(String message) {
        super(message);
    }
}
