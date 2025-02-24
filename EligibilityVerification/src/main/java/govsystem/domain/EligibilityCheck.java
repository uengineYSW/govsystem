package govsystem.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import govsystem.EligibilityVerificationApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "EligibilityCheck_table")
@Data
//<<< DDD / Aggregate Root
public class EligibilityCheck {

    @Id
    private String eligibilityCheckId;

    @Enumerated(EnumType.STRING)
    private QualificationStatus qualificationStatus;

    @Embedded
    private InquiryHistoryItem inquiryHistory;

    @Embedded
    private ServiceApplicationId serviceApplicationId;

    public static EligibilityCheckRepository repository() {
        EligibilityCheckRepository eligibilityCheckRepository = EligibilityVerificationApplication.applicationContext.getBean(
            EligibilityCheckRepository.class
        );
        return eligibilityCheckRepository;
    }

    //<<< Clean Arch / Port Method
    public void checkEligibility(
        CheckEligibilityCommand checkEligibilityCommand
    ) {
        //implement business logic here:

        EligibilityChecked eligibilityChecked = new EligibilityChecked(this);
        eligibilityChecked.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
