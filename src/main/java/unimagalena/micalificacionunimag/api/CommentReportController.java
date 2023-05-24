package unimagalena.micalificacionunimag.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unimagalena.micalificacionunimag.entities.CommentReport;
import unimagalena.micalificacionunimag.services.CommentReportService;

@RestController
@RequestMapping("/api/v3")
public class CommentReportController {
    
    @Autowired
    private final CommentReportService commentReportService;

    public CommentReportController(CommentReportService commentReportService) {
        this.commentReportService = commentReportService;
    }

    @GetMapping("/commentreports")
    public ResponseEntity<List<CommentReport>> getAllCommentReports()
    {
        List<CommentReport> commentReports = commentReportService.findAll();
        if(commentReports.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(commentReports);
        }        
    }

    @GetMapping("/commentreports/{id}")
    public ResponseEntity<Optional<CommentReport>> getCommentReportById(@PathVariable Long id)
    {
        Optional<CommentReport> data = commentReportService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }

    @PostMapping("/commentreports")
    public ResponseEntity<CommentReport> createCommentReport(@PathVariable Long id, @RequestBody CommentReport commentReport)
    {
        CommentReport data = commentReportService.create(id, commentReport);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/commentreports/{id}")
    public ResponseEntity<Optional<CommentReport>> updateCommentReport(@PathVariable Long id, @RequestBody CommentReport commentReport)
    {
        Optional<CommentReport> data = commentReportService.update(id, commentReport);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @DeleteMapping("/commentreports/{id}")
    public ResponseEntity<String> deleteCommentReport(@PathVariable Long id)
    {
        commentReportService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
    
}
