package govsystem.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InquiryHistoryItem {

    private String inquiryId;

    private String applicantId;

    private String residentRegistrationNumber;

    private String foreignerRegistrationNumber;

    private String rejectionReason;

    private Date inquiryTime;

    private QualificationStatus qualificationStatus;
}
//>>> DDD / Value Object
