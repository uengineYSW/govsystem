package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ApplicationDocumentDraftSaved extends AbstractEvent {

    private Long documentId;
    private ApplicationFormData applicationFormData;
    private String electronicSignatureData;
    private DraftHistoryRecord draftHistoryRecord;
    private SecurityRating securityRating;
    private ServiceApplicationId serviceApplicationId;
    private FormTemplateId formTemplateId;
    private Date savedAt;

    public ApplicationDocumentDraftSaved(ApplicationDocument aggregate) {
        super(aggregate);
    }

    public ApplicationDocumentDraftSaved() {
        super();
    }
}
//>>> DDD / Domain Event
