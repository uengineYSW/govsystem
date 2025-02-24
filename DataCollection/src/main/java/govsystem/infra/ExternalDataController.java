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
// @RequestMapping(value="/externalData")
@Transactional
public class ExternalDataController {

    @Autowired
    ExternalDataRepository externalDataRepository;

    @RequestMapping(
        value = "/externalData",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ExternalData retrieveExternalData(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RetrieveExternalDataCommand retrieveExternalDataCommand
    ) throws Exception {
        System.out.println(
            "##### /externalData/retrieveExternalData  called #####"
        );
        ExternalData externalData = new ExternalData();
        externalData.retrieveExternalData(retrieveExternalDataCommand);
        externalDataRepository.save(externalData);
        return externalData;
    }
}
//>>> Clean Arch / Inbound Adaptor
