package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ServiceApplicationTemporarySaved extends AbstractEvent {

    private String applicationId;
    private User user;
    private String serviceType;
    private String formData;
    private String attachment;
    private ProgressStatus progressStatus;
    private Date savedAt;

    public ServiceApplicationTemporarySaved(ServiceApplication aggregate) {
        super(aggregate);
    }

    public ServiceApplicationTemporarySaved() {
        super();
    }
}
//>>> DDD / Domain Event
