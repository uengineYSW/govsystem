package govsystem.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateFormTemplateCommand {

    private String formType;
    private String version;
    private String mappingRule;
    private String previewContent;
    private String alternativeTemplate;
}
