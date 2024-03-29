package com.clevertech.mylabo.web.rest;

import com.clevertech.mylabo.service.MylabofrontKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mylabofront-kafka")
public class MylabofrontKafkaResource {

    private final Logger log = LoggerFactory.getLogger(MylabofrontKafkaResource.class);

    private MylabofrontKafkaProducer kafkaProducer;

    public MylabofrontKafkaResource(MylabofrontKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
