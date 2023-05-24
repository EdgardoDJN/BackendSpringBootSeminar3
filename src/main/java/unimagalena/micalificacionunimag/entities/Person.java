package unimagalena.micalificacionunimag.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="persons")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//tipo objetuales no primitivos

    @OneToOne(mappedBy = "person")
    private User user;

    @Column(nullable = false)
    private String FirstName;
    @Column(nullable = false)
    private String MiddleName;
    @Column(nullable = false)
    private String FirstLastName;
    @Column(nullable = false)
    private String SecondLastName;
}
