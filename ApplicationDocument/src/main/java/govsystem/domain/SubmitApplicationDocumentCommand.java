package govsystem.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubmitApplicationDocumentCommand {

    private ApplicationFormData applicationFormData;
    private String electronicSignatureData;
    private SecurityRating securityRating;
    private ServiceApplicationId serviceApplicationId;
    private FormTemplateId formTemplateId;
}
