package unimagalena.micalificacionunimag.api.dto;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsDTO {
    private Double promedio;
    private Double totalCalificaciones;
    private Double habilidadExplicacion;
    private Double metodologiaEvaluacion;
    private Double tratoEstudiante;
    private Double usoTecnologia;
    private Double metodologia;
}
