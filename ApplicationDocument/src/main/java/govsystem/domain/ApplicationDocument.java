package govsystem.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import govsystem.ApplicationDocumentApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ApplicationDocument_table")
@Data
//<<< DDD / Aggregate Root
public class ApplicationDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;

    @Embedded
    private ApplicationFormData applicationFormData;

    private String electronicSignatureData;

    @Embedded
    private DraftHistoryRecord draftHistoryRecord;

    @Enumerated(EnumType.STRING)
    private SecurityRating securityRating;

    @Embedded
    private ServiceApplicationId serviceApplicationId;

    @Embedded
    private FormTemplateId formTemplateId;

    public static ApplicationDocumentRepository repository() {
        ApplicationDocumentRepository applicationDocumentRepository = ApplicationDocumentApplication.applicationContext.getBean(
            ApplicationDocumentRepository.class
        );
        return applicationDocumentRepository;
    }

    //<<< Clean Arch / Port Method
    public void submitApplicationDocument(
        SubmitApplicationDocumentCommand submitApplicationDocumentCommand
    ) {
        //implement business logic here:

        ApplicationDocumentSubmitted applicationDocumentSubmitted = new ApplicationDocumentSubmitted(
            this
        );
        applicationDocumentSubmitted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void saveDraftApplicationDocument(
        SaveDraftApplicationDocumentCommand saveDraftApplicationDocumentCommand
    ) {
        //implement business logic here:

        ApplicationDocumentDraftSaved applicationDocumentDraftSaved = new ApplicationDocumentDraftSaved(
            this
        );
        applicationDocumentDraftSaved.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
