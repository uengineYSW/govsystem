package govsystem.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterIssuedDocumentCommand {

    private Long documentId;
    private String systemIntegration;
    private String documentClassification;
    private String securityLevel;
    private Integer retentionPeriod;
}
