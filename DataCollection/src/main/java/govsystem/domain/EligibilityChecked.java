package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class EligibilityChecked extends AbstractEvent {

    private String applicantId;
    private String residentRegistrationNumber;
    private String foreignerRegistrationNumber;
    private Object qualificationStatus;
    private String rejectionReason;
    private Date inquiryTime;
}
