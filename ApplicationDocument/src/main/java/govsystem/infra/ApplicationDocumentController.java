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
// @RequestMapping(value="/applicationDocuments")
@Transactional
public class ApplicationDocumentController {

    @Autowired
    ApplicationDocumentRepository applicationDocumentRepository;

    @RequestMapping(
        value = "/applicationDocuments",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ApplicationDocument submitApplicationDocument(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SubmitApplicationDocumentCommand submitApplicationDocumentCommand
    ) throws Exception {
        System.out.println(
            "##### /applicationDocument/submitApplicationDocument  called #####"
        );
        ApplicationDocument applicationDocument = new ApplicationDocument();
        applicationDocument.submitApplicationDocument(
            submitApplicationDocumentCommand
        );
        applicationDocumentRepository.save(applicationDocument);
        return applicationDocument;
    }

    @RequestMapping(
        value = "/applicationDocuments",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ApplicationDocument saveDraftApplicationDocument(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SaveDraftApplicationDocumentCommand saveDraftApplicationDocumentCommand
    ) throws Exception {
        System.out.println(
            "##### /applicationDocument/saveDraftApplicationDocument  called #####"
        );
        ApplicationDocument applicationDocument = new ApplicationDocument();
        applicationDocument.saveDraftApplicationDocument(
            saveDraftApplicationDocumentCommand
        );
        applicationDocumentRepository.save(applicationDocument);
        return applicationDocument;
    }
}
//>>> Clean Arch / Inbound Adaptor
