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

import unimagalena.micalificacionunimag.entities.TeacherProfilePost;
import unimagalena.micalificacionunimag.services.TeacherProfilePostService;

@RestController 
@RequestMapping("/api/v3")
public class TeacherProfilePostController {
    @Autowired
    private final TeacherProfilePostService teacherProfilePostService;

    public TeacherProfilePostController(TeacherProfilePostService teacherProfilePostService) {
        this.teacherProfilePostService = teacherProfilePostService;
    }

    @GetMapping("/teacherProfilePosts")
    public ResponseEntity<List<TeacherProfilePost>> getAllTeacherProfilePosts()
    {
        List<TeacherProfilePost> teacherProfilePosts = teacherProfilePostService.findAll();
        if(teacherProfilePosts.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.ok(teacherProfilePosts);
        }        
    }
    @GetMapping("/teacherProfilePosts/{id}")
    public ResponseEntity<Optional<TeacherProfilePost>> getTeacherProfilePostById(@PathVariable Long id)
    {
        Optional<TeacherProfilePost> data = teacherProfilePostService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }
    @PostMapping("/teacherProfilePosts/{id}")
    public ResponseEntity<TeacherProfilePost> createTeacherProfilePost(@RequestBody TeacherProfilePost teacherProfilePost)
    {
        TeacherProfilePost data = teacherProfilePostService.create(teacherProfilePost);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }
    @PutMapping("/teacherProfilePosts/{id}")
    public ResponseEntity<Optional<TeacherProfilePost>> updateTeacherProfilePost(@PathVariable Long id, @RequestBody TeacherProfilePost teacherProfilePost)
    {
        Optional<TeacherProfilePost> data = teacherProfilePostService.update(id, teacherProfilePost);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(data);
        }
    }
    @DeleteMapping("/teacherProfilePosts/{id}")
    public ResponseEntity<String> deleteTeacherProfilePost(@PathVariable Long id)
    {
        teacherProfilePostService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("TeacherProfilePost deleted");
    }
}
