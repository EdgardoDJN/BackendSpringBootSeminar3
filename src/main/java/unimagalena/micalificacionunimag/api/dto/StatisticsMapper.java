package unimagalena.micalificacionunimag.api.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StatisticsMapper {
    public static List<StatisticsDTO> convertToStatisticsDto(List<Object[]> data) {
        List<StatisticsDTO> statisticsList = new ArrayList<>();
    
        data.forEach(obj -> {
            Double promedio = ((Number) obj[0]).doubleValue();
            Double totalCalificaciones = ((Number) obj[1]).doubleValue();
            Double habilidadExplicacion = ((Number) obj[2]).doubleValue();
            Double metodologiaEvaluacion = ((Number) obj[3]).doubleValue();
            Double tratoEstudiante = ((Number) obj[4]).doubleValue();
            Double usoTecnologia = ((Number) obj[5]).doubleValue();
            Double metodologia = ((Number) obj[6]).doubleValue();
    
            StatisticsDTO statistics = new StatisticsDTO();
            statistics.setPromedio(promedio);
            statistics.setTotalCalificaciones(totalCalificaciones);
            statistics.setHabilidadExplicacion(habilidadExplicacion);
            statistics.setMetodologiaEvaluacion(metodologiaEvaluacion);
            statistics.setTratoEstudiante(tratoEstudiante);
            statistics.setUsoTecnologia(usoTecnologia);
            statistics.setMetodologia(metodologia);
            statisticsList.add(statistics);
        });
    
        return statisticsList;
    }  
    public static List<StatisticsDTO2> convertToStatisticsDto2(List<Object[]> data) {
        List<StatisticsDTO2> statisticsList = new ArrayList<>();
    
        data.forEach(obj -> {
            Double promedio = ((Number) obj[5]).doubleValue();
            Double habilidadExplicacion = ((Number) obj[3]).doubleValue();
            Double metodologiaEvaluacion = ((Number) obj[2]).doubleValue();
            Double tratoEstudiante = ((Number) obj[0]).doubleValue();
            Double usoTecnologia = ((Number) obj[4]).doubleValue();
            Double metodologia = ((Number) obj[1]).doubleValue();
    
            StatisticsDTO2 statistics = new StatisticsDTO2();
            statistics.setPromedio(promedio);
            statistics.setHabilidadExplicacion(habilidadExplicacion);
            statistics.setMetodologiaEvaluacion(metodologiaEvaluacion);
            statistics.setTratoEstudiante(tratoEstudiante);
            statistics.setUsoTecnologia(usoTecnologia);
            statistics.setMetodologia(metodologia);
            statisticsList.add(statistics);
        });
    
        return statisticsList;
    }            
    
}
