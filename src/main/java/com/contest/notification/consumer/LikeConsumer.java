package com.contest.notification.consumer;

import com.contest.notification.dto.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LikeConsumer implements Consumer{


    @KafkaListener(topics="${like.kafka.topic}",containerFactory = "headerConcurrentKafkaListenerContainerFactory")
    public void receiveMessage(Header header) {
        LOGGER.info("Received:"+ header);
    }

    @Override
    public String processMessage(Header header) {

        return null;
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(LikeConsumer.class);
}