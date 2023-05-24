package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.TeacherProfilePost;
import unimagalena.micalificacionunimag.repositories.TeacherProfilePostRepository;

@Service
public class TeacherProfilePostImpl implements TeacherProfilePostService {

    @Autowired
    private final TeacherProfilePostRepository teacherProfilePostRepository;

    public TeacherProfilePostImpl(TeacherProfilePostRepository teacherProfilePostRepository) {
        this.teacherProfilePostRepository = teacherProfilePostRepository;
    }

    @Override
    public TeacherProfilePost create(TeacherProfilePost teacherProfilePost) {
        TeacherProfilePost copy = new TeacherProfilePost(
            null,
            null,
            teacherProfilePost.getStudent(),
            teacherProfilePost.getTeacher()
        );
        return teacherProfilePostRepository.save(copy);
    }

    @Override
    public Optional<TeacherProfilePost> update(Long id, TeacherProfilePost teacherProfilePost){
        return teacherProfilePostRepository.findById(id).map(tpp -> {
            tpp.setStudent(teacherProfilePost.getStudent());
            tpp.setTeacher(teacherProfilePost.getTeacher());
            return teacherProfilePostRepository.save(tpp);
        });
    }

    @Override
    public List<TeacherProfilePost> findAll() {
        return teacherProfilePostRepository.findAll();
    }

    @Override
    public Optional<TeacherProfilePost> find(Long id) {
        return teacherProfilePostRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        teacherProfilePostRepository.deleteById(id);
    }
    
}
