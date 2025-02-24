package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ServiceApplicationSubmitted extends AbstractEvent {

    private String applicationId;
    private Object user;
    private String serviceType;
    private String formData;
    private String attachment;
    private Object progressStatus;
    private Date submittedAt;
}
