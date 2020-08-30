package in.co.madhur.kafka.concurency.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SpringConsumer {

    private final Logger logger = LoggerFactory.getLogger(SpringConsumer.class);


    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "test-topic")
    public void consume(String message) {
        logger.info(String.format("$$ -> Consumed Message -> %s",message));
    }

}
