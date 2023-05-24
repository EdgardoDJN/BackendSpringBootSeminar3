package unimagalena.micalificacionunimag.exceptions;

public class PublicationNotFoundException extends RuntimeException {
    
    public PublicationNotFoundException() {
        super("La publicación asignada a ese id no se encuentra registrado.");
    }

    public PublicationNotFoundException(String message) {
        super(message);
    }
}
