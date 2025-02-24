package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class IssuedDocumentRegistered extends AbstractEvent {

    private Long documentId;
    private String systemIntegration;
    private String documentClassification;
    private String securityLevel;
    private Integer retentionPeriod;
    private Date registeredAt;

    public IssuedDocumentRegistered(IssuedDocument aggregate) {
        super(aggregate);
    }

    public IssuedDocumentRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
