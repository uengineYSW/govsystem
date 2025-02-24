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
@Table(name = "ServiceApplication_table")
@Data
//<<< DDD / Aggregate Root
public class ServiceApplication {

    @Id
    private String applicationId;

    @Embedded
    private User user;

    private String serviceType;

    private String formData;

    private String attachment;

    @Enumerated(EnumType.STRING)
    private ProgressStatus progressStatus;

    public static ServiceApplicationRepository repository() {
        ServiceApplicationRepository serviceApplicationRepository = ServiceApplicationApplication.applicationContext.getBean(
            ServiceApplicationRepository.class
        );
        return serviceApplicationRepository;
    }

    //<<< Clean Arch / Port Method
    public void submitServiceApplication(
        SubmitServiceApplicationCommand submitServiceApplicationCommand
    ) {
        //implement business logic here:

        ServiceApplicationSubmitted serviceApplicationSubmitted = new ServiceApplicationSubmitted(
            this
        );
        serviceApplicationSubmitted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void saveTemporaryServiceApplication(
        SaveTemporaryServiceApplicationCommand saveTemporaryServiceApplicationCommand
    ) {
        //implement business logic here:

        ServiceApplicationTemporarySaved serviceApplicationTemporarySaved = new ServiceApplicationTemporarySaved(
            this
        );
        serviceApplicationTemporarySaved.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
