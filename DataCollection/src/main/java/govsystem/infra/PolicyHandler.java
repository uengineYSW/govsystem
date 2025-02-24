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
    ExternalDataRepository externalDataRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='EligibilityChecked'"
    )
    public void wheneverEligibilityChecked_ExternalDataRetrievalPolicy(
        @Payload EligibilityChecked eligibilityChecked
    ) {
        EligibilityChecked event = eligibilityChecked;
        System.out.println(
            "\n\n##### listener ExternalDataRetrievalPolicy : " +
            eligibilityChecked +
            "\n\n"
        );
        // Comments //
        //자격 검증 완료 후, 추가 정보를 보완하기 위해 DataCollection BC의 RetrieveExternalData 커맨드를 호출하여 외부 시스템에서 데이터를 조회합니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
