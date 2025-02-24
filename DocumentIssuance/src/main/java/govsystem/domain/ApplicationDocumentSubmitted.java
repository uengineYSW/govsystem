package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ApplicationDocumentSubmitted extends AbstractEvent {

    private Long documentId;
    private Object applicationFormData;
    private String electronicSignatureData;
    private Object securityRating;
    private Object serviceApplicationId;
    private Object formTemplateId;
    private Date submittedAt;
}
