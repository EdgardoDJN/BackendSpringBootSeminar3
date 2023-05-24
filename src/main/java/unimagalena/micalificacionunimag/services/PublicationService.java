package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.Publication;

public interface PublicationService {
    Publication create(Long idteacherProfilePost, Publication publication);
    Optional<Publication> update(Long id, Publication publication);
    List<Publication> findAll();
    Optional<Publication> find(Long id);
    void delete(Long id);
}
