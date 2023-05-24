package unimagalena.micalificacionunimag.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comment_reports")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentReport {
    @Id
    private Long id;//tipo objetuales no primitivos

    @OneToOne(fetch = FetchType.LAZY)
    //@MapsId
    @JoinColumn(name = "publication_id")
    private Publication publication;

    private String reason;
}
