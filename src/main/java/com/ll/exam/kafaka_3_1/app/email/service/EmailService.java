package com.ll.exam.kafaka_3_1.app.email.service;

import com.ll.exam.kafaka_3_1.util.Ut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    public void send(String email, String msg) {
        Ut.kafka.send(
                "sendEmail__joinComplete",
                Ut.mapOf(
                        "email", email,
                        "msg", msg
                ),
                result -> {
                    ProducerRecord producerRecord = result.getProducerRecord();

                    log.debug("서버1 : 토픽 sendEmail__joinComplete 메세지 송신");
                    log.debug("producerRecord.key() : {}", producerRecord.key());
                    log.debug("producerRecord.value() : {}", producerRecord.value());
                },
                Throwable::printStackTrace
        );
    }
}
