package in.co.madhur.kafka.concurency;


import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import javax.annotation.PostConstruct;
import javax.xml.ws.soap.Addressing;


@SpringBootApplication
public class ConsumerApplication {

    @Autowired
    private CamelContext ctx;

//    @Autowired
//    private SimpleKafkaConsumer simpleKafkaConsumer;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }

//    @PostConstruct
//    public void run() throws Exception {
//        ctx.addRoutes(simpleKafkaConsumer);
//    }
}
