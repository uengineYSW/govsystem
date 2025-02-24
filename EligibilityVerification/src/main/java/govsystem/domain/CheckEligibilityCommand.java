package govsystem.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CheckEligibilityCommand {

    private String applicantId;
    private String residentRegistrationNumber;
    private String foreignerRegistrationNumber;
    private List<String> qualificationItems;
    private String apiKey;
    private String authToken;
    private String ipRestriction;
    private String digitalSignature;
}
