package govsystem.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import govsystem.ServiceApplicationApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FormTemplate_table")
@Data
//<<< DDD / Aggregate Root
public class FormTemplate {

    @Id
    private String templateId;

    private String formType;

    private String version;

    private String mappingRule;

    private String previewContent;

    private String alternativeTemplate;

    public static FormTemplateRepository repository() {
        FormTemplateRepository formTemplateRepository = ServiceApplicationApplication.applicationContext.getBean(
            FormTemplateRepository.class
        );
        return formTemplateRepository;
    }

    //<<< Clean Arch / Port Method
    public void createFormTemplate(
        CreateFormTemplateCommand createFormTemplateCommand
    ) {
        //implement business logic here:

        FormTemplateCreated formTemplateCreated = new FormTemplateCreated(this);
        formTemplateCreated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
