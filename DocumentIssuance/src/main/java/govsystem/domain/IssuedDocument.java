package govsystem.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import govsystem.DocumentIssuanceApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "IssuedDocument_table")
@Data
//<<< DDD / Aggregate Root
public class IssuedDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;

    @Embedded
    private EdmsIntegrationInfo edmsIntegrationInfo;

    @Embedded
    private PdfProcessingInfo pdfProcessingInfo;

    private EDMSStatus edmsStatus;

    private PDFDocumentStatus pdfStatus;

    @Embedded
    private EligibilityCheckId eligibilityCheckId;

    @Embedded
    private ExternalDataId externalDataId;

    @Embedded
    private ApplicationDocumentId applicationDocumentId;

    public static IssuedDocumentRepository repository() {
        IssuedDocumentRepository issuedDocumentRepository = DocumentIssuanceApplication.applicationContext.getBean(
            IssuedDocumentRepository.class
        );
        return issuedDocumentRepository;
    }

    //<<< Clean Arch / Port Method
    public void registerIssuedDocument(
        RegisterIssuedDocumentCommand registerIssuedDocumentCommand
    ) {
        //implement business logic here:

        IssuedDocumentRegistered issuedDocumentRegistered = new IssuedDocumentRegistered(
            this
        );
        issuedDocumentRegistered.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void processIssuedDocumentPdf(
        ProcessIssuedDocumentPdfCommand processIssuedDocumentPdfCommand
    ) {
        //implement business logic here:

        IssuedDocumentPdfProcessed issuedDocumentPdfProcessed = new IssuedDocumentPdfProcessed(
            this
        );
        issuedDocumentPdfProcessed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
