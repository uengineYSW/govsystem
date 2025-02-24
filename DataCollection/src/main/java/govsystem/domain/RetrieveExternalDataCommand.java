package govsystem.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RetrieveExternalDataCommand {

    private String collectionId;
    private String systemName;
    private String queryItems;
    private String queryPeriod;
    private Integer priority;
    private String dataProcessingRules;
    private IntegrationDetails integrationDetails;
}
