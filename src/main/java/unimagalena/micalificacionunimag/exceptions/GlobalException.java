package unimagalena.micalificacionunimag.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException  {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> personNotFoundHandler( PersonNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(FacultyNotFoundException.class)
    public ResponseEntity<ErrorResponse> facultyNotFoundHandler( FacultyNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(ProgramNotFoundException.class)
    public ResponseEntity<ErrorResponse> programNotFoundHandler( ProgramNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundHandler( UserNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> studentNotFoundHandler( StudentNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<ErrorResponse> teacherNotFoundHandler( TeacherNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(TeacherProfilePostNotFoundException.class)
    public ResponseEntity<ErrorResponse> teacherProfilePostNotFoundHandler( TeacherProfilePostNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(SemesterNotFoundException.class)
    public ResponseEntity<ErrorResponse> semesterProfilePostNotFoundHandler( SemesterNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(SemesterTeacherNotFoundException.class)
    public ResponseEntity<ErrorResponse> semesterTeacherNotFoundHandler( SemesterTeacherNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(SemesterStudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> semesterStudentNotFoundHandler( SemesterStudentNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(PublicationNotFoundException.class)
    public ResponseEntity<ErrorResponse> publicationNotFoundHandler( PublicationNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(CommentReportNotFoundException.class)
    public ResponseEntity<ErrorResponse> commentReportNotFoundHandler( CommentReportNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(SubjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> subjectNotFoundHandler( SubjectNotFoundException ex, 
                            WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setDescription(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
