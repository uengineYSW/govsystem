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
public class EdmsIntegrationInfo {

    private String systemIntegration;

    private String documentClassification;

    private String securityLevel;

    private Integer retentionPeriod;
}
//>>> DDD / Value Object
