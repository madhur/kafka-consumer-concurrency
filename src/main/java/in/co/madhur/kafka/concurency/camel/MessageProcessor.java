//package in.co.madhur.kafka.concurency.camel;
//
//import org.apache.camel.Exchange;
//import org.apache.camel.Processor;
//import org.springframework.stereotype.Component;
//
//
//public class MessageProcessor implements Processor {
//    @Override
//    public void process(Exchange exchange) throws Exception {
//        String message = (String) exchange.getIn().getBody();
//        System.out.println("Properties:");
//        for(String key: exchange.getProperties().keySet()) {
//            System.out.println(key + " : " + exchange.getProperties().get(key));
//        }
//        System.out.println("Headers:");
//        for(String key: exchange.getIn().getHeaders().keySet()) {
//            System.out.println(key + " : " + exchange.getIn().getHeaders().get(key));
//        }
//        System.out.println("message: " + message);
//    }
//}
