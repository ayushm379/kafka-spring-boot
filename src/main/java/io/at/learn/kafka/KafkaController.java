package io.at.learn.kafka;

import io.at.learn.kafka.lesson01.producer.Producer01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    @Autowired
    private Producer01 producer;

    @GetMapping("/lesson01")
    public String lesson01API(@RequestParam("message") String message) {
        for(int i=1; i<=10; i++) {
            String key = "Key" + i;
            String msg = message + i;
            producer.sendMessage(key, msg);
        }
        return "ALL MESSAGES ARE SENT";
    }


}
