package govsystem.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ServiceApplicationStatusQuery {

    private String applicationId;
    private ProgressStatus progressStatus;
}
