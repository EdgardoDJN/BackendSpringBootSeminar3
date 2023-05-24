package unimagalena.micalificacionunimag.exceptions;

public class CommentReportNotFoundException extends RuntimeException {
    
    public CommentReportNotFoundException() {
        super("El reporte de comentario asignado a ese id no se encuentra registrado.");
    }

    public CommentReportNotFoundException(String message) {
        super(message);
    }
}
