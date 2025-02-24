package govsystem.domain;

import govsystem.domain.*;
import govsystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ExternalDataRetrieved extends AbstractEvent {

    private String collectionId;
    private String systemName;
    private String queryItems;
    private String queryPeriod;
    private Integer priority;
    private String dataProcessingRules;
    private Object verificationStatus;
    private String transformedData;
    private Date retrievedAt;
}
