package unimagalena.micalificacionunimag.api.dto;

import java.util.ArrayList;
import java.util.List;

import unimagalena.micalificacionunimag.entities.Calification;

public class CalificationMapper {
    public static CalificationDTO toCalificationDTO(Calification calification) {
        CalificationDTO dto = new CalificationDTO();
        dto.setTratoEstudiante(calification.getTratoEstudiante());
        dto.setMetodologia(calification.getMetodologia());
        dto.setMetodologiaEvaluacion(calification.getMetodologiaEvaluacion());
        dto.setExplicacionClase(calification.getHabilidadExplicacion());
        dto.setUsoTecnologia(calification.getUsoTecnologia());
        dto.setCalificacion(calification.getCalificacion());
        return dto;
    }
    public static Calification toCalification(CalificationDTO calificationDTO) {
        Calification calification = new Calification();
        calification.setTratoEstudiante(calificationDTO.getTratoEstudiante());
        calification.setMetodologia(calificationDTO.getMetodologia());
        calification.setMetodologiaEvaluacion(calificationDTO.getMetodologiaEvaluacion());
        calification.setHabilidadExplicacion(calificationDTO.getExplicacionClase());
        calification.setUsoTecnologia(calificationDTO.getUsoTecnologia());
        calification.setCalificacion(calificationDTO.getCalificacion());
        return calification;
    }
}
