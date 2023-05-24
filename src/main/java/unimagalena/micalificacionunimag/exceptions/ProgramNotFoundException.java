package unimagalena.micalificacionunimag.exceptions;

public class ProgramNotFoundException extends RuntimeException {
    
    public ProgramNotFoundException() {
        super("El programa asignado a ese id no se encuentra registrado.");
    }

    public ProgramNotFoundException(String message) {
        super(message);
    }
}
