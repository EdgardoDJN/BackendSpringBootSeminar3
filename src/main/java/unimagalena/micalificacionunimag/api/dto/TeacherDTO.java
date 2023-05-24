package unimagalena.micalificacionunimag.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

    private long id;
    private String nombre;
    private String apellido;
    private double calificacion;


}
