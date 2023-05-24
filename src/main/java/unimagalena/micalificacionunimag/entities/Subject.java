package unimagalena.micalificacionunimag.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="subjects")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//tipo objetuales no primitivos

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean mandatory;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Credit gender;

    @ManyToMany()
    @JoinTable(name="subject_semester_students", joinColumns = @JoinColumn(name="subject_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="semester_student_id", referencedColumnName = "id"))
    private List<SemesterStudent> semesterStudents = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name="subject_teachers", joinColumns = @JoinColumn(name="subject_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="teacher_id", referencedColumnName = "id"))
    private List<Teacher> teachers = new ArrayList<>();
}
