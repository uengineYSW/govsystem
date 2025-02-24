package govsystem.domain;

import java.util.Date;
import lombok.Data;

@Data
public class FormTemplatePreviewQuery {

    private String formType;
    private String templateId;
}
