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
    collectionResourceRel = "formTemplates",
    path = "formTemplates"
)
public interface FormTemplateRepository
    extends PagingAndSortingRepository<FormTemplate, String> {
    @Query(
        value = "select formTemplate " +
        "from FormTemplate formTemplate " +
        "where(:formType is null or formTemplate.formType like %:formType%) and (:templateId is null or formTemplate.templateId like %:templateId%)"
    )
    List<FormTemplate> formTemplatePreview(
        String formType,
        String templateId,
        Pageable pageable
    );
}
