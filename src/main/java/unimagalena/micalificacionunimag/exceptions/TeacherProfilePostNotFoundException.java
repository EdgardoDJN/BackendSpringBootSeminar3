package unimagalena.micalificacionunimag.exceptions;

public class TeacherProfilePostNotFoundException extends RuntimeException {
    
    public TeacherProfilePostNotFoundException() {
        super("El post del perfil del profesor asignado a ese id no se encuentra registrado.");
    }

    public TeacherProfilePostNotFoundException(String message) {
        super(message);
    }
}
