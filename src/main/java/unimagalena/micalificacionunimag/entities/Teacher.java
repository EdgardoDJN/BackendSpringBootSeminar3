package unimagalena.micalificacionunimag.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="teachers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
 
    @Id
    private Long id;

    @OneToOne
    //@MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Boolean ContractType;

    @ManyToMany()
    @JoinTable(name="teacher_programs", joinColumns = @JoinColumn(name="teacher_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="program_id", referencedColumnName = "id"))
    private List<Program> programs = new ArrayList<>();


    @OneToMany(mappedBy = "teacher")
    private List<SemesterTeacher> semesterTeachers;

    @ManyToMany(mappedBy = "teachers")
    private List<SemesterTeacher> SemesterTeachers2;

    @ManyToMany(mappedBy = "teachers")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "teacher")
    private List<TeacherProfilePost> teacherProfilePosts;

    @OneToMany(mappedBy = "teacher")
    private List<Calification> califications;
}
