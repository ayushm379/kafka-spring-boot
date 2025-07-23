package io.at.learn.kafka.lesson01.consumer;

import io.at.learn.kafka.lesson01.producer.KafkaProducerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = KafkaProducerConfig.TOPIC_NAME, groupId = KafkaConsumer01Config.GROUP_ID)
    public void consume01(@Payload String message,
                          @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                          @Header(KafkaHeaders.OFFSET) int offset) {
        System.out.println("************** MESSAGE RECEIVED BY Consumer 01: ************** " + message + " " + partition + " " + offset);
    }

    @KafkaListener(topics = KafkaProducerConfig.TOPIC_NAME, groupId = KafkaConsumer02Config.GROUP_ID)
    public void consume02(@Payload String message,
                          @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                          @Header(KafkaHeaders.OFFSET) int offset) {
        System.out.println("************** MESSAGE RECEIVED BY Consumer 02: ************** " + message + " " + partition + " " + offset);
    }

}
