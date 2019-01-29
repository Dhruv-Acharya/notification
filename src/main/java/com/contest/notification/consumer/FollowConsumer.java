package com.contest.notification.consumer;

import com.contest.notification.dto.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class FollowConsumer implements Consumer {
    @KafkaListener(topics="${follow.kafka.topic}",containerFactory = "headerConcurrentKafkaListenerContainerFactory")
    public void receiveMessage(Header header) {
        LOGGER.info("Received:"+ header);
    }

    @Override
    public String processMessage(Header header) {
        return null;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(FollowConsumer.class);

}
