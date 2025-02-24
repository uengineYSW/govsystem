package govsystem.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import govsystem.config.kafka.KafkaProcessor;
import govsystem.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    IssuedDocumentRepository issuedDocumentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ApplicationDocumentSubmitted'"
    )
    public void wheneverApplicationDocumentSubmitted_DocumentIssuancePolicy(
        @Payload ApplicationDocumentSubmitted applicationDocumentSubmitted
    ) {
        ApplicationDocumentSubmitted event = applicationDocumentSubmitted;
        System.out.println(
            "\n\n##### listener DocumentIssuancePolicy : " +
            applicationDocumentSubmitted +
            "\n\n"
        );
        // Comments //
        //ApplicationDocument 제출 후, 제출된 신청서를 기반으로 DocumentIssuance BC의 RegisterIssuedDocument 커맨드를 호출하여 발급 프로세스를 자동으로 진행함으로써 사용자가 실시간 진행 상태를 확인할 수 있도록 합니다.

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ApplicationDocumentSubmitted'"
    )
    public void wheneverApplicationDocumentSubmitted_PdfProcessingPolicy(
        @Payload ApplicationDocumentSubmitted applicationDocumentSubmitted
    ) {
        ApplicationDocumentSubmitted event = applicationDocumentSubmitted;
        System.out.println(
            "\n\n##### listener PdfProcessingPolicy : " +
            applicationDocumentSubmitted +
            "\n\n"
        );
        // Comments //
        //신청서 제출 후 발급문서에 대해 PDF 문서를 생성하고, 전자서명, 보안 워터마크 및 출력 제어를 적용하여 문서 보안과 무결성을 확보하기 위함

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
