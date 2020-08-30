package in.co.madhur.kafka.concurency.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private Producer producer;

    @PostMapping("/produce")
    public ResponseEntity<String> produce(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
