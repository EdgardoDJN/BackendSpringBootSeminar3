package unimagalena.micalificacionunimag.exceptions;

public class SemesterStudentNotFoundException extends RuntimeException {
    
    public SemesterStudentNotFoundException() {
        super("El semestre asignado a ese id no se encuentra registrado.");
    }

    public SemesterStudentNotFoundException(String message) {
        super(message);
    }
}
