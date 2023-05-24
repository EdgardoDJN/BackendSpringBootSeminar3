package unimagalena.micalificacionunimag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimagalena.micalificacionunimag.entities.CommentReport;
import unimagalena.micalificacionunimag.entities.Publication;
import unimagalena.micalificacionunimag.repositories.CommentReportRepository;
import unimagalena.micalificacionunimag.repositories.PublicationRepository;

@Service
public class CommentReportServiceImpl implements CommentReportService {

    @Autowired
    private final CommentReportRepository commentReportRepository;

    @Autowired
    private final PublicationRepository publicationRepository;

    public CommentReportServiceImpl(CommentReportRepository commentReportRepository, PublicationRepository publicationRepository) {
        this.commentReportRepository = commentReportRepository;
        this.publicationRepository = publicationRepository;
    }

    @Override
    public CommentReport create(Long idpublication, CommentReport commentReport) {
        Publication publication = publicationRepository.findById(idpublication).orElse(null);
        CommentReport copy = new CommentReport(
            idpublication,
            publication,
            commentReport.getReason()
        );
        return commentReportRepository.save(copy);
    }

    @Override
    public Optional<CommentReport> update(Long id, CommentReport commentReport) {
        return commentReportRepository.findById(id).map(c -> {
            c.setReason(commentReport.getReason());
            return commentReportRepository.save(c);
        });
    }

    @Override
    public List<CommentReport> findAll() {
        return commentReportRepository.findAll();
    }

    @Override
    public Optional<CommentReport> find(Long id) {
        return commentReportRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        commentReportRepository.deleteById(id);
    }
    
}
