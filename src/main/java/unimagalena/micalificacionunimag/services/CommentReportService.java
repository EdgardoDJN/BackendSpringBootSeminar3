package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import unimagalena.micalificacionunimag.entities.CommentReport;

public interface CommentReportService {
    CommentReport create(Long idpublication, CommentReport commentReport);
    Optional<CommentReport> update(Long id, CommentReport commentReport);
    List<CommentReport> findAll();
    Optional<CommentReport> find(Long id);
    void delete(Long id);
}
