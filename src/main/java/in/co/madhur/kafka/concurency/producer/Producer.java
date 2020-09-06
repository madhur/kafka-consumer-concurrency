package in.co.madhur.kafka.concurency.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Producer {

    private static final String TOPIC = "test-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        this.kafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), message);
    }

    public void sendBatchMessages() {
        for (int i = 1; i < 10; i++){
            this.kafkaTemplate.send("test-topic3", UUID.randomUUID().toString(), "message-" + i);
        }
    }
}
