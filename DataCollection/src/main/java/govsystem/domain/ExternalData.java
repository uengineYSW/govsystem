package govsystem.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import govsystem.DataCollectionApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ExternalData_table")
@Data
//<<< DDD / Aggregate Root
public class ExternalData {

    @Id
    private String collectionId;

    private String systemName;

    private String queryItems;

    private String queryPeriod;

    private Integer priority;

    private String dataProcessingRules;

    @Enumerated(EnumType.STRING)
    private DataVerificationStatus verificationStatus;

    @Embedded
    private QueryHistoryItem queryHistory;

    public static ExternalDataRepository repository() {
        ExternalDataRepository externalDataRepository = DataCollectionApplication.applicationContext.getBean(
            ExternalDataRepository.class
        );
        return externalDataRepository;
    }

    //<<< Clean Arch / Port Method
    public void retrieveExternalData(
        RetrieveExternalDataCommand retrieveExternalDataCommand
    ) {
        //implement business logic here:

        ExternalDataRetrieved externalDataRetrieved = new ExternalDataRetrieved(
            this
        );
        externalDataRetrieved.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
