package com.adhoc.erna;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import javax.transaction.Transactional;
import java.io.IOException;


public class SensorMessageHandler implements MessageHandler {

    private ObjectMapper objectMapper;
    private ApplicationEventPublisher publisher;

    SensorMessageHandler(ObjectMapper objectMapper, ApplicationEventPublisher publisher) {
        this.objectMapper = objectMapper;
        this.publisher = publisher;
    }

    @Override
    @Transactional
    public void handleMessage(Message<?> message) throws MessagingException {
        try {
            System.out.println(message.getPayload());
            SensorMessage sensorMessage = objectMapper.readValue((String) message.getPayload(), SensorMessage.class);

            if (sensorMessage.isEvent()) {
                publisher.publishEvent(new FenceStatusReceived(this, FenceStatus.from(sensorMessage)));
            }
        } catch (IOException e) {
            throw new MessagingException(message, e);
        }
    }
}
