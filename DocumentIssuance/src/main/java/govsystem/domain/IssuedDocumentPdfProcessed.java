package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class IssuedDocumentPdfProcessed extends AbstractEvent {

    private Long documentId;
    private String template;
    private String font;
    private Double margin;
    private String resolution;
    private String encryptionLevel;
    private Boolean outputControl;
    private String watermarkPosition;
    private String securityLevel;
    private Date processedAt;

    public IssuedDocumentPdfProcessed(IssuedDocument aggregate) {
        super(aggregate);
    }

    public IssuedDocumentPdfProcessed() {
        super();
    }
}
//>>> DDD / Domain Event
