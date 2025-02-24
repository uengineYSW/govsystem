package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ServiceApplicationSubmitted extends AbstractEvent {

    private String applicationId;
    private User user;
    private String serviceType;
    private String formData;
    private String attachment;
    private ProgressStatus progressStatus;
    private Date submittedAt;

    public ServiceApplicationSubmitted(ServiceApplication aggregate) {
        super(aggregate);
    }

    public ServiceApplicationSubmitted() {
        super();
    }
}
//>>> DDD / Domain Event
