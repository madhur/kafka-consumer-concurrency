package in.co.madhur.kafka.concurency.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringConsumer {

    private final Logger logger = LoggerFactory.getLogger(SpringConsumer.class);


    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "test-topic")
    public void consume(@Payload String message, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                        @Header(KafkaHeaders.OFFSET) int offset,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        logger.info("Received from partition: " + partition + " offset: " + offset + " with key: " + key);
        logger.info(String.format("$$ -> Consumed Message -> %s",message));
    }

    @KafkaListener(containerFactory = "batchKafkaListenerContainerFactory", topics = "test-topic2")
    public void consume(@Payload List<String> messages, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Integer> offsets,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Acknowledgment acknowledgment) {
        logger.info("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        logger.info("beginning to consume batch messages");

        for (int i = 0; i < messages.size(); i++) {

            logger.info("received message='{}' with partition-offset='{}'",
                    messages.get(i), partitions.get(i) + "-" + offsets.get(i));

        }
        logger.info("all batch messages consumed");
        acknowledgment.acknowledge();
    }





}
