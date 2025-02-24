package govsystem.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ApplicationDocumentDetailsQuery {

    private Long documentId;
    private ApplicationFormData applicationFormData;
    private String electronicSignatureData;
    private DraftHistoryRecord draftHistoryRecord;
    private SecurityRating securityRating;
    private ServiceApplicationId serviceApplicationId;
    private FormTemplateId formTemplateId;
}
