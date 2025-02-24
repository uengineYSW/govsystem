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
// @RequestMapping(value="/issuedDocuments")
@Transactional
public class IssuedDocumentController {

    @Autowired
    IssuedDocumentRepository issuedDocumentRepository;

    @RequestMapping(
        value = "/issuedDocuments",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public IssuedDocument registerIssuedDocument(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RegisterIssuedDocumentCommand registerIssuedDocumentCommand
    ) throws Exception {
        System.out.println(
            "##### /issuedDocument/registerIssuedDocument  called #####"
        );
        IssuedDocument issuedDocument = new IssuedDocument();
        issuedDocument.registerIssuedDocument(registerIssuedDocumentCommand);
        issuedDocumentRepository.save(issuedDocument);
        return issuedDocument;
    }

    @RequestMapping(
        value = "/issuedDocuments",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public IssuedDocument processIssuedDocumentPdf(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ProcessIssuedDocumentPdfCommand processIssuedDocumentPdfCommand
    ) throws Exception {
        System.out.println(
            "##### /issuedDocument/processIssuedDocumentPdf  called #####"
        );
        IssuedDocument issuedDocument = new IssuedDocument();
        issuedDocument.processIssuedDocumentPdf(
            processIssuedDocumentPdfCommand
        );
        issuedDocumentRepository.save(issuedDocument);
        return issuedDocument;
    }
}
//>>> Clean Arch / Inbound Adaptor
