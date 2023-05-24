package unimagalena.micalificacionunimag.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="semesters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//tipo objetuales no primitivos

    private LocalDate InitialDate;

    @OneToMany(mappedBy = "semester")
    private List<SemesterStudent> SemesterStudents;

    @OneToMany(mappedBy = "semester")
    private List<SemesterTeacher> semesterTeachers;
}
