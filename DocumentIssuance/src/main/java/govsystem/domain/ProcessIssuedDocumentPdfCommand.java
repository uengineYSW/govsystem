package govsystem.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ProcessIssuedDocumentPdfCommand {

    private Long documentId;
    private String template;
    private String font;
    private Double margin;
    private String resolution;
    private String encryptionLevel;
    private Boolean outputControl;
    private String watermarkPosition;
    private String securityLevel;
}
