package unimagalena.micalificacionunimag.entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="students")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private Long id;

    @OneToOne
    //@MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDate registered;

    @OneToMany(mappedBy = "student")
    private List<SemesterStudent> SemesterStudents;

    @OneToMany(mappedBy = "student")
    private List<TeacherProfilePost> teacherProfilePosts;
    
    @OneToMany(mappedBy = "student")
    private List<Calification> califications;

}
