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
// @RequestMapping(value="/formTemplates")
@Transactional
public class FormTemplateController {

    @Autowired
    FormTemplateRepository formTemplateRepository;

    @RequestMapping(
        value = "/formTemplates",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public FormTemplate createFormTemplate(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateFormTemplateCommand createFormTemplateCommand
    ) throws Exception {
        System.out.println(
            "##### /formTemplate/createFormTemplate  called #####"
        );
        FormTemplate formTemplate = new FormTemplate();
        formTemplate.createFormTemplate(createFormTemplateCommand);
        formTemplateRepository.save(formTemplate);
        return formTemplate;
    }
}
//>>> Clean Arch / Inbound Adaptor
