package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.TeacherProfilePost;

public interface TeacherProfilePostService {
    TeacherProfilePost create(TeacherProfilePost teacherProfilePost);
    Optional<TeacherProfilePost> update(Long id, TeacherProfilePost teacherProfilePost);
    List<TeacherProfilePost> findAll();
    Optional<TeacherProfilePost> find(Long id);
    void delete(Long id);
}
