package unimagalena.micalificacionunimag.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="publications")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    @Id
    private Long id;

    @OneToOne
    //@MapsId
    @JoinColumn(name = "teacherProfilePost_id")
    private TeacherProfilePost teacherProfilePost;

    @OneToOne(mappedBy = "publication")
    private CommentReport commentReport;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Publication parent;
    
    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private int like;

    @Column(nullable = false)
    private int dislike;
}
