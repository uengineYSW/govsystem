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
    collectionResourceRel = "applicationDocuments",
    path = "applicationDocuments"
)
public interface ApplicationDocumentRepository
    extends PagingAndSortingRepository<ApplicationDocument, Long> {
    @Query(
        value = "select applicationDocument " +
        "from ApplicationDocument applicationDocument " +
        "where(:documentId is null or applicationDocument.documentId = :documentId) and (:applicationFormData is null or applicationDocument.applicationFormData = :applicationFormData) and (:electronicSignatureData is null or applicationDocument.electronicSignatureData like %:electronicSignatureData%) and (:draftHistoryRecord is null or applicationDocument.draftHistoryRecord = :draftHistoryRecord) and (:securityRating is null or applicationDocument.securityRating = :securityRating) and (:serviceApplicationId is null or applicationDocument.serviceApplicationId = :serviceApplicationId) and (:formTemplateId is null or applicationDocument.formTemplateId = :formTemplateId)"
    )
    ApplicationDocument applicationDocumentDetails(
        Long documentId,
        ApplicationFormData applicationFormData,
        String electronicSignatureData,
        DraftHistoryRecord draftHistoryRecord,
        SecurityRating securityRating,
        ServiceApplicationId serviceApplicationId,
        FormTemplateId formTemplateId
    );
}
