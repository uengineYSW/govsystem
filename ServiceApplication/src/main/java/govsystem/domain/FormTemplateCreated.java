package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FormTemplateCreated extends AbstractEvent {

    private String templateId;
    private String formType;
    private String version;
    private String mappingRule;
    private String previewContent;
    private String alternativeTemplate;
    private Date createdAt;

    public FormTemplateCreated(FormTemplate aggregate) {
        super(aggregate);
    }

    public FormTemplateCreated() {
        super();
    }
}
//>>> DDD / Domain Event
