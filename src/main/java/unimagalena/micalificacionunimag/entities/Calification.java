package unimagalena.micalificacionunimag.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="califications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false)
    private Double calificacion;

    @Column(nullable = false)
    private Double TratoEstudiante;

    @Column(nullable = false)
    private Double metodologia;

    @Column(nullable = false)
    private Double HabilidadExplicacion;

    @Column(nullable = false)
    private Double UsoTecnologia;

    @Column(nullable = false)
    private Double MetodologiaEvaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
}
