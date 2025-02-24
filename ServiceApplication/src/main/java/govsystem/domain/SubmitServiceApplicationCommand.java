package govsystem.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubmitServiceApplicationCommand {

    private User user;
    private String serviceType;
    private String formData;
    private String attachment;
}
