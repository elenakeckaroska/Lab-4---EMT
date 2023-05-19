package com.example.doctorpatient.doctor.infra;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DomainPublisherImpl implements DomainEventPublisher {

    private final KafkaTemplate<String, String > kafkaTemplate;
    @Override
    public void publish(DomainEvent event) {
        this.kafkaTemplate.send(event.topic(), event.toJson());
    }
}
