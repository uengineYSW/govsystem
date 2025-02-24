package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ExternalDataRetrieved extends AbstractEvent {

    private String collectionId;
    private String systemName;
    private String queryItems;
    private String queryPeriod;
    private Integer priority;
    private String dataProcessingRules;
    private DataVerificationStatus verificationStatus;
    private String transformedData;
    private Date retrievedAt;

    public ExternalDataRetrieved(ExternalData aggregate) {
        super(aggregate);
    }

    public ExternalDataRetrieved() {
        super();
    }
}
//>>> DDD / Domain Event
