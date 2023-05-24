package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.Publication;
import unimagalena.micalificacionunimag.entities.TeacherProfilePost;
import unimagalena.micalificacionunimag.repositories.PublicationRepository;
import unimagalena.micalificacionunimag.repositories.TeacherProfilePostRepository;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private final PublicationRepository publicationRepository;

    @Autowired
    private final TeacherProfilePostRepository teacherProfilePostRepository;

    public PublicationServiceImpl(PublicationRepository publicationRepository,
            TeacherProfilePostRepository teacherProfilePostRepository) {
        this.publicationRepository = publicationRepository;
        this.teacherProfilePostRepository = teacherProfilePostRepository;
    }

    @Override
    public Publication create(Long idteacherProfilePost, Publication publication) {
        TeacherProfilePost teacherProfilePost = teacherProfilePostRepository.findById(idteacherProfilePost).orElse(null);
        Publication copy = new Publication(
            idteacherProfilePost,
            teacherProfilePost,
            null,
            publication.getParent(),
            publication.getComment(),
            publication.getLike(),
            publication.getDislike()
        );
        return publicationRepository.save(copy);
    }

    @Override
    public Optional<Publication> update(Long id, Publication publication) {
        return publicationRepository.findById(id).map(p -> {
            p.setParent(publication.getParent());
            p.setComment(publication.getComment());
            p.setLike(publication.getLike());
            p.setDislike(publication.getDislike());
            return publicationRepository.save(p);
        });
    }

    @Override
    public List<Publication> findAll() {
        return publicationRepository.findAll();
    }

    @Override
    public Optional<Publication> find(Long id) {
        return publicationRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        publicationRepository.deleteById(id);
    }
    
}
