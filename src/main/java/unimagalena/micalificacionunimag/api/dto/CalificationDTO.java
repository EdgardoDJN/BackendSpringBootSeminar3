package unimagalena.micalificacionunimag.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalificationDTO {
    private Double tratoEstudiante;
    private Double metodologia;
    private Double metodologiaEvaluacion;
    private Double explicacionClase;
    private Double usoTecnologia;
    private Double calificacion;
}
