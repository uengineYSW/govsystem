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
    EligibilityCheckRepository eligibilityCheckRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ServiceApplicationSubmitted'"
    )
    public void wheneverServiceApplicationSubmitted_EligibilityVerificationPolicy(
        @Payload ServiceApplicationSubmitted serviceApplicationSubmitted
    ) {
        ServiceApplicationSubmitted event = serviceApplicationSubmitted;
        System.out.println(
            "\n\n##### listener EligibilityVerificationPolicy : " +
            serviceApplicationSubmitted +
            "\n\n"
        );
        // Comments //
        //ServiceApplication 제출 후, 신청자의 자격 검증을 위해 EligibilityVerification BC의 CheckEligibility 커맨드를 호출하여 필수 입력 필드와 추가 자격 조건을 검증합니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
