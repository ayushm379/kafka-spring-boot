package io.at.learn.kafka.lesson01.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer01 {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String key, String message) {
        System.out.println("************** SENDING MESSAGE FROM PRODUCER: ************** " + key + "-" + message);
        kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME, message);
    }

    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name(KafkaProducerConfig.TOPIC_NAME).partitions(2).build();
    }

}
