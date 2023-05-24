package unimagalena.micalificacionunimag.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.springframework.stereotype.Component;
import unimagalena.micalificacionunimag.entities.Teacher;

@Component
public class TeacherMapper {

    /*
    public static List<TeacherFullDTO> convertToDto(List<Object[]> data) {
        List<TeacherFullDTO> teachers = data.stream()
        .map(obj -> {
            TeacherFullDTO teacher = new TeacherFullDTO();
            teacher.setId(((BigInteger) obj[0]).longValue());
            teacher.setNombres((String) obj[1]);
            teacher.setApellidos((String) obj[2]);

            ProgramDTO program = new ProgramDTO();
            Object[] programObj = (Object[]) obj[3];
            //program.setId(((BigInteger) programObj[0]).longValue());
            program.setNombre((String) programObj[1]);
            //program.setIdfacultad((long) programObj[2]);

            teacher.setProgramas(Collections.singletonList(program));

            SubjectDTO subject = new SubjectDTO();
            Object[] subjectObj = (Object[]) obj[4];
            //subject.setId(((BigInteger) subjectObj[0]).longValue());
            subject.setName((String) subjectObj[1]);
            //subject.setDescription((String) subjectObj[2]);
            //subject.setMandatory((boolean) subjectObj[3]);
            //subject.setCreditos((String) subjectObj[4]);

            teacher.setMaterias(Collections.singletonList(subject));

            teacher.setCalificacion((Double) obj[5]);

            return teacher;
        })
        .collect(Collectors.toList());

    return teachers;
    }
    */
    /*public static List<TeacherFullDTO> convertToDto(List<Object[]> data, List<Teacher> teachers3) {
        List<String> programas = new ArrayList<String>();
        List<TeacherFullDTO> teachers = data.stream()
        .map(obj -> {
            TeacherFullDTO teacher = new TeacherFullDTO();
            teacher.setId(((BigInteger) obj[0]).longValue());
            teacher.setNombres((String) obj[1]);
            teacher.setApellidos((String) obj[2]);

            ProgramDTO program = new ProgramDTO();
            String programObj = (String) obj[3];
            program.setNombre(programObj);
            //program.setId(((BigInteger) programObj[0]).longValue());
            //program.setNombre((String) programObj[1]);
            //program.setIdfacultad((long) programObj[2]);

            teacher.setPrograma(Collections.singletonList(program));

            SubjectDTO subject = new SubjectDTO();
            String subjectObj = (String) obj[4];
            subject.setNombre(subjectObj);
            //subject.setId(((BigInteger) subjectObj[0]).longValue());
            //subject.setName((String) subjectObj[1]);
            //subject.setDescription((String) subjectObj[2]);
            //subject.setMandatory((boolean) subjectObj[3]);
            //subject.setCreditos((String) subjectObj[4]);

            teacher.setMateria(Collections.singletonList(subject));

            teacher.setCalificacion((Double) obj[5]);

            return teacher;
        })
        .collect(Collectors.toList());

    return teachers;
    }
    */
    /*public static List<TeacherFullDTO> convertToDto(List<Object[]> data, List<Teacher> teachers3) {
        Map<Long, List<ProgramDTO>> programasMap = new HashMap<>();
        Map<Long, List<SubjectDTO>> materiasMap = new HashMap<>();
    
        List<TeacherFullDTO> teachers = data.stream()
            .map(obj -> {
                TeacherFullDTO teacher = new TeacherFullDTO();
                teacher.setId(((BigInteger) obj[0]).longValue());
                teacher.setNombres((String) obj[1]);
                teacher.setApellidos((String) obj[2]);
    
                // Agregar programa al mapa de programas por id de profesor
                Long teacherId = teacher.getId();
                ProgramDTO program = new ProgramDTO();
                program.setNombre((String) obj[3]);
    
                programasMap.computeIfAbsent(teacherId, key -> new ArrayList<>()).add(program);
    
                // Agregar materia al mapa de materias por id de profesor
                SubjectDTO subject = new SubjectDTO();
                subject.setNombre((String) obj[4]);
    
                materiasMap.computeIfAbsent(teacherId, key -> new ArrayList<>()).add(subject);
    
                teacher.setCalificacion((Double) obj[5]);
    
                return teacher;
            })
            .collect(Collectors.toList());
    
        // Asignar programas y materias correspondientes a cada profesor
        for (TeacherFullDTO teacher : teachers) {
            Long teacherId = teacher.getId();
            List<ProgramDTO> programas = programasMap.getOrDefault(teacherId, Collections.emptyList());
            List<SubjectDTO> materias = materiasMap.getOrDefault(teacherId, Collections.emptyList());
    
            teacher.setPrograma(programas);
            teacher.setMateria(materias);
        }
    
        return teachers;
    }
    */
    

    /*public static List<TeacherDTO> convertToDto2(List<Object[]> data) {
    return data.stream()
    .map(obj -> {
        TeacherDTO teacher = new TeacherDTO();
        teacher.setId(((BigInteger) obj[0]).longValue());
        teacher.setNombre((String) obj[1]);
        teacher.setApellido((String) obj[2]);
        teacher.setCalificacion((Double) obj[3]);
        return teacher;
    })
    .collect(Collectors.toList());
    }
    */
    /*public static String convertToDto(List<Object[]> data, List<Teacher> teachers3) {
        Map<Long, TeacherFullDTO> teachersMap = new HashMap<>();
    
        data.forEach(obj -> {
            Long id = ((BigInteger) obj[0]).longValue();
            String nombres = (String) obj[1];
            String apellidos = (String) obj[2];
            String programObj = (String) obj[3];
            String subjectObj = (String) obj[4];
            Double calificacion = (Double) obj[5];
    
            TeacherFullDTO teacher;
            if (teachersMap.containsKey(id)) {
                teacher = teachersMap.get(id);
            } else {
                teacher = new TeacherFullDTO();
                teacher.setId(id);
                teacher.setNombres(nombres);
                teacher.setApellidos(apellidos);
                teacher.setCalificacion(calificacion);
                teacher.setPrograma(new ArrayList<>()); // Inicializar lista de programas
                teacher.setMateria(new ArrayList<>()); // Inicializar lista de materias
                teachersMap.put(id, teacher);
            }
    
            // Verificar si el programa ya existe en la lista
            boolean programaExistente = teacher.getPrograma().stream()
                    .anyMatch(p -> p.getNombre().equals(programObj));
    
            if (!programaExistente) {
                ProgramDTO program = new ProgramDTO();
                program.setNombre(programObj);
                teacher.getPrograma().add(program);
            }
    
            SubjectDTO subject = new SubjectDTO();
            subject.setNombre(subjectObj);
            teacher.getMateria().add(subject);
        });
    
        //return new ArrayList<>(teachersMap.values());
        List<TeacherFullDTO> teacherList = new ArrayList<>(teachersMap.values());
        Gson gson = new GsonBuilder().create();
        return gson.toJson(teacherList);
    }
    */
    public static List<TeacherFullDTO> convertToDto(List<Object[]> data, List<Teacher> teachers3) {
        Map<Long, TeacherFullDTO> teachersMap = new HashMap<>();
    
        data.forEach(obj -> {
            Long id = ((BigInteger) obj[0]).longValue();
            String nombres = (String) obj[1];
            String apellidos = (String) obj[2];
            String programObj = (String) obj[3];
            String subjectObj = (String) obj[4];
            Double calificacion = (Double) obj[5];
    
            TeacherFullDTO teacher;
            if (teachersMap.containsKey(id)) {
                teacher = teachersMap.get(id);
            } else {
                teacher = new TeacherFullDTO();
                teacher.setId(id);
                teacher.setNombres(nombres);
                teacher.setApellidos(apellidos);
                teacher.setCalificacion(calificacion);
                teacher.setPrograma(new ArrayList<>()); // Inicializar lista de programas
                teacher.setMateria(new ArrayList<>()); // Inicializar lista de materias
                teachersMap.put(id, teacher);
            }
    
            // Verificar si el programa ya existe en la lista
            boolean programaExistente = teacher.getPrograma().stream()
                    .anyMatch(p -> p.getNombre().equals(programObj));
    
            if (!programaExistente) {
                ProgramDTO program = new ProgramDTO();
                program.setNombre(programObj);
                teacher.getPrograma().add(program);
            }
    
            SubjectDTO subject = new SubjectDTO();
            subject.setNombre(subjectObj);
            teacher.getMateria().add(subject);
        });
    
        return new ArrayList<>(teachersMap.values());
        //List<TeacherFullDTO> teacherList = new ArrayList<>(teachersMap.values());
        //Gson gson = new GsonBuilder().create();
        //return gson.toJson(teacherList);
    }


    
}
