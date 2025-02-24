package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class EligibilityChecked extends AbstractEvent {

    private String applicantId;
    private String residentRegistrationNumber;
    private String foreignerRegistrationNumber;
    private QualificationStatus qualificationStatus;
    private String rejectionReason;
    private Date inquiryTime;

    public EligibilityChecked(EligibilityCheck aggregate) {
        super(aggregate);
    }

    public EligibilityChecked() {
        super();
    }
}
//>>> DDD / Domain Event
