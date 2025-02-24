package govsystem.domain;

import govsystem.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "issuedDocuments",
    path = "issuedDocuments"
)
public interface IssuedDocumentRepository
    extends PagingAndSortingRepository<IssuedDocument, Long> {
    @Query(
        value = "select issuedDocument " +
        "from IssuedDocument issuedDocument " +
        "where(:documentId is null or issuedDocument.documentId = :documentId)"
    )
    IssuedDocument issuedDocumentStatus(Long documentId);
}
