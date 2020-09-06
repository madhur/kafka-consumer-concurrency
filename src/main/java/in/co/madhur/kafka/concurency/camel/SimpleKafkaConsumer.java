//package in.co.madhur.kafka.concurency.camel;
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//public class SimpleKafkaConsumer extends RouteBuilder {
//
//    @Autowired
//    private MessageProcessor messageProcessor;
//
//    @Override
//    public void configure() throws Exception {
//        from("kafka:test-topic2?brokers=localhost:9092&groupId=camel-consumer&consumersCount=2")
//                .process(messageProcessor);
//    }
//}