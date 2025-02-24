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
    ApplicationDocumentRepository applicationDocumentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ServiceApplicationTemporarySaved'"
    )
    public void wheneverServiceApplicationTemporarySaved_DraftApplicationSyncPolicy(
        @Payload ServiceApplicationTemporarySaved serviceApplicationTemporarySaved
    ) {
        ServiceApplicationTemporarySaved event =
            serviceApplicationTemporarySaved;
        System.out.println(
            "\n\n##### listener DraftApplicationSyncPolicy : " +
            serviceApplicationTemporarySaved +
            "\n\n"
        );
        // Comments //
        //ServiceApplication의 임시저장 이벤트 발생 시, ApplicationDocument의 초안 저장 명령을 호출하여 작성 이력을 관리하고 사용자 경험을 개선합니다.

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
