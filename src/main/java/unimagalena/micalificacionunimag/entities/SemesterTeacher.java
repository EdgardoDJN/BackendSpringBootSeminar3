package unimagalena.micalificacionunimag.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="semester_teachers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//tipo objetuales no primitivos

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToMany()
    @JoinTable(name="subject_semester_teachers", joinColumns = @JoinColumn(name="semester_teacher_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="teacher_id", referencedColumnName = "id"))
    private List<Teacher> teachers = new ArrayList<>();
}
