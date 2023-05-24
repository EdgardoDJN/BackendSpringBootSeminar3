package unimagalena.micalificacionunimag.exceptions;

public class SemesterTeacherNotFoundException extends RuntimeException {
    
    public SemesterTeacherNotFoundException() {
        super("El semestre asignado a ese id no se encuentra registrado.");
    }

    public SemesterTeacherNotFoundException(String message) {
        super(message);
    }
}
