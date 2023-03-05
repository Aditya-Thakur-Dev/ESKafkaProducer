package com.learn.esproducer;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final StreamBridge streamBridge;

    private final String BINDER = "kafkaProducer-out-0";

    public Producer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public <T> boolean produce(T event){
        return this.streamBridge.send(BINDER, MessageBuilder.withPayload(event).build());
    }
}
