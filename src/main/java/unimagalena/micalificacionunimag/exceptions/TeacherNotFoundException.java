package unimagalena.micalificacionunimag.exceptions;

public class TeacherNotFoundException extends RuntimeException {
    
    public TeacherNotFoundException() {
        super("El docente asignado a ese id no se encuentra registrado.");
    }
    public TeacherNotFoundException(String message) {
        super(message);
    }
}
