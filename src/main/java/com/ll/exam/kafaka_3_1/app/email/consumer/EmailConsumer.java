package com.ll.exam.kafaka_3_1.app.email.consumer;

import com.ll.exam.kafaka_3_1.util.Ut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@EnableKafka
@Service
public class EmailConsumer {
    @KafkaListener(
            topics = "sendEmail__joinCompleteDone", groupId = "group-01")
    public void listenWith___sendEmailDone__joinComplete(
            @Payload String payload,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {

        Map<String, Object> payloadJson = Ut.json.toMap(payload);

        String email = (String) payloadJson.get("email");
        String msg = (String) payloadJson.get("msg");

        log.debug("서버1 : 토픽 sendEmail__joinCompleteDone 메세지 수신");
        log.debug("email : {}", email);
        log.debug("msg : {}", msg);
    }
}
