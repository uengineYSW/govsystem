package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ApplicationDocumentSubmitted extends AbstractEvent {

    private Long documentId;
    private ApplicationFormData applicationFormData;
    private String electronicSignatureData;
    private SecurityRating securityRating;
    private ServiceApplicationId serviceApplicationId;
    private FormTemplateId formTemplateId;
    private Date submittedAt;

    public ApplicationDocumentSubmitted(ApplicationDocument aggregate) {
        super(aggregate);
    }

    public ApplicationDocumentSubmitted() {
        super();
    }
}
//>>> DDD / Domain Event
