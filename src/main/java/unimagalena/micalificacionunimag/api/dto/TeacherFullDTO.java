package unimagalena.micalificacionunimag.api.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unimagalena.micalificacionunimag.entities.Program;
import unimagalena.micalificacionunimag.entities.Subject;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherFullDTO {
    private long id;
    private String nombres;
    private String apellidos;
    //@SerializedName("programa")
    private List<ProgramDTO> programa;
    //@SerializedName("materia")
    private List<SubjectDTO> materia;
    private Double calificacion;
}
