package govsystem.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ExternalDataQueryHistoryQuery {

    private String collectionId;
    private String systemName;
    private Date retrievedAt;
}
