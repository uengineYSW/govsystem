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
    ServiceApplicationRepository serviceApplicationRepository;

    @Autowired
    FormTemplateRepository formTemplateRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ServiceApplicationSubmitted'"
    )
    public void wheneverServiceApplicationSubmitted_FormTemplateMappingPolicy(
        @Payload ServiceApplicationSubmitted serviceApplicationSubmitted
    ) {
        ServiceApplicationSubmitted event = serviceApplicationSubmitted;
        System.out.println(
            "\n\n##### listener FormTemplateMappingPolicy : " +
            serviceApplicationSubmitted +
            "\n\n"
        );
        // Comments //
        //민원 서비스 신청 접수 시, ServiceApplication BC 내의 FormTemplate Aggregate에서 CreateFormTemplate 커맨드를 호출하여 해당 민원에 적합한 서식을 자동으로 조회하고 사용자 입력 데이터를 매핑합니다.

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ExternalDataRetrieved'"
    )
    public void wheneverExternalDataRetrieved_ExternalDataPostProcessingPolicy(
        @Payload ExternalDataRetrieved externalDataRetrieved
    ) {
        ExternalDataRetrieved event = externalDataRetrieved;
        System.out.println(
            "\n\n##### listener ExternalDataPostProcessingPolicy : " +
            externalDataRetrieved +
            "\n\n"
        );
        // Comments //
        //수집된 외부 데이터의 정합성과 정제를 보장하고, 누락된 데이터 발생 시 재조회 처리를 지원하며, 조회 이력을 관리하기 위해 외부 데이터 조회 완료 후 서비스 신청 임시 저장소를 업데이트합니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
