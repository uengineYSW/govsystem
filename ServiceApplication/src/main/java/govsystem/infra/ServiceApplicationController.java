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
// @RequestMapping(value="/serviceApplications")
@Transactional
public class ServiceApplicationController {

    @Autowired
    ServiceApplicationRepository serviceApplicationRepository;

    @RequestMapping(
        value = "/serviceApplications",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ServiceApplication submitServiceApplication(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SubmitServiceApplicationCommand submitServiceApplicationCommand
    ) throws Exception {
        System.out.println(
            "##### /serviceApplication/submitServiceApplication  called #####"
        );
        ServiceApplication serviceApplication = new ServiceApplication();
        serviceApplication.submitServiceApplication(
            submitServiceApplicationCommand
        );
        serviceApplicationRepository.save(serviceApplication);
        return serviceApplication;
    }

    @RequestMapping(
        value = "/serviceApplications",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ServiceApplication saveTemporaryServiceApplication(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SaveTemporaryServiceApplicationCommand saveTemporaryServiceApplicationCommand
    ) throws Exception {
        System.out.println(
            "##### /serviceApplication/saveTemporaryServiceApplication  called #####"
        );
        ServiceApplication serviceApplication = new ServiceApplication();
        serviceApplication.saveTemporaryServiceApplication(
            saveTemporaryServiceApplicationCommand
        );
        serviceApplicationRepository.save(serviceApplication);
        return serviceApplication;
    }
}
//>>> Clean Arch / Inbound Adaptor
