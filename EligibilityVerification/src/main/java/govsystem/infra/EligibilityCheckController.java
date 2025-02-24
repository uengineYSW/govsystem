package govsystem.infra;

import govsystem.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/eligibilityChecks")
@Transactional
public class EligibilityCheckController {

    @Autowired
    EligibilityCheckRepository eligibilityCheckRepository;

    @RequestMapping(
        value = "/eligibilityChecks",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public EligibilityCheck checkEligibility(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CheckEligibilityCommand checkEligibilityCommand
    ) throws Exception {
        System.out.println(
            "##### /eligibilityCheck/checkEligibility  called #####"
        );
        EligibilityCheck eligibilityCheck = new EligibilityCheck();
        eligibilityCheck.checkEligibility(checkEligibilityCommand);
        eligibilityCheckRepository.save(eligibilityCheck);
        return eligibilityCheck;
    }
}
//>>> Clean Arch / Inbound Adaptor
