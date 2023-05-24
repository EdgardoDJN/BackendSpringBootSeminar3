package unimagalena.micalificacionunimag.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import unimagalena.micalificacionunimag.api.dto.StatisticsDTO;
import unimagalena.micalificacionunimag.api.dto.StatisticsMapper;
import unimagalena.micalificacionunimag.api.dto.TeacherFullDTO;
import unimagalena.micalificacionunimag.api.dto.TeacherMapper;
import unimagalena.micalificacionunimag.entities.Teacher;
import unimagalena.micalificacionunimag.services.TeacherService;

@RestController
@RequestMapping("/api/v3")
//@SecurityRequirement(name = "techgeeknext-api")
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers()
    {
            List<Teacher> data = teacherService.findAll();   
            return ResponseEntity.status(HttpStatus.FOUND).body(data); 
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Optional<Teacher>> getTeacherById(@PathVariable Long id)
    {
        Optional<Teacher> data = teacherService.find(id);
        if(data.isEmpty())
            return ResponseEntity.noContent().build();
        else
        {
            return ResponseEntity.status(HttpStatus.FOUND).body(data);
        }
    }


    @GetMapping("/teachers/subjectName")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<List<TeacherFullDTO>> getTeachersBySubjectName(@RequestParam(required = true) String subjectName)
    {
        List<Object[]> data = teacherService.findTeachersBySubjectName(subjectName);
        List<Teacher> teachers1 = teacherService.findAll();
        List<TeacherFullDTO> teachers = TeacherMapper.convertToDto(data, teachers1);
        //List<TeacherFullDTO> teachers = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.FOUND).body(teachers);
    }

    @GetMapping("/teachers/teacherName")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<List<TeacherFullDTO>> getTeachersByTeacherName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String middleName, @RequestParam(required = false) String firstLastName, @RequestParam(required = false) String secondLastName)
    {
        List<Object[]> data = teacherService.findByTeacherName(firstName, middleName, firstLastName, secondLastName);
        List<Teacher> teachers1 = teacherService.findAll();
        List<TeacherFullDTO> teachers = TeacherMapper.convertToDto(data, teachers1);
        //List<TeacherFullDTO> teachers = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.FOUND).body(teachers);
    }
    @GetMapping("/teachers/programName")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<List<TeacherFullDTO>> getTeachersByProgram(@RequestParam(required = true) String programName)
    {
        List<Object[]> data = teacherService.findTeachersByProgram(programName);
        List<Teacher> teachers1 = teacherService.findAll();
        List<TeacherFullDTO> teachers = TeacherMapper.convertToDto(data, teachers1);
        //List<TeacherFullDTO> teachers = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.FOUND).body(teachers);
    }
    /*@GetMapping("/teachers5")
    public ResponseEntity<List<Object[]>> getTeachers() {
        List<Object[]> data = teacherService.findTeachers();
        return ResponseEntity.status(HttpStatus.FOUND).body(data);
        
    }
    */
    /*@GetMapping("/teachers5")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers2() {
        List<Object[]> data = teacherService.findTeachers();
        List<TeacherDTO> teachers = TeacherMapper.convertToDto2(data);
        return ResponseEntity.status(HttpStatus.FOUND).body(teachers);
    }
    */
    @GetMapping("/teachers/allTeachers")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<List<TeacherFullDTO>> getAllTeachers2() {
        List<Object[]> data = teacherService.findTeachers();
        List<Teacher> teachers1 = teacherService.findAll();
        List<TeacherFullDTO> teachers = TeacherMapper.convertToDto(data, teachers1);
        //List<TeacherFullDTO> teachers = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.FOUND).body(teachers);
    }
    @GetMapping("/teachers/teachersWithBestResults")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<List<TeacherFullDTO>> getTeachersWithBestResults()
    {
        List<Object[]> data = teacherService.findTeachersWithBestResults();
        List<Teacher> teachers1 = teacherService.findAll();
        List<TeacherFullDTO> teachers = TeacherMapper.convertToDto(data, teachers1);
        //List<TeacherFullDTO> teachers = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.FOUND).body(teachers);
    }
    @GetMapping("/teachers/teachersWithBestResultsInEducationalTecnology")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<List<TeacherFullDTO>> getTeachersWithBestResultsInEducationalTecnology()
    {
        List<Object[]> data = teacherService.findTeachersWithBestResultsInEducationalTecnology();
        List<Teacher> teachers1 = teacherService.findAll();
        //String teachers = TeacherMapper.convertToDto(data, teachers1);
        List<TeacherFullDTO> teachers = TeacherMapper.convertToDto(data, teachers1);
        return ResponseEntity.status(HttpStatus.FOUND).body(teachers);

    }
    @GetMapping("/teachers/teacherStatistics/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<List<StatisticsDTO>> getTeacherStatistics(@PathVariable Long id)
    {
        List<Object[]> data = teacherService.getTeacherStatistics(id);
        List<StatisticsDTO> teachers = StatisticsMapper.convertToStatisticsDto(data);
        return ResponseEntity.status(HttpStatus.FOUND).body(teachers);
    }

    @PostMapping("/teachers/{id}")
    public ResponseEntity<Teacher> createTeacher(@PathVariable Long id, @RequestBody Teacher teacher)
    {
        Teacher data = teacherService.create(id, teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<Optional<Teacher>> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher)
    {
        Optional<Teacher> data = teacherService.update(id, teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @DeleteMapping ("/teachers/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id)
    {
        teacherService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Teacher deleted");
    }
}
