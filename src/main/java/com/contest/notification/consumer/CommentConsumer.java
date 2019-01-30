package com.contest.notification.consumer;


import com.contest.notification.dto.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CommentConsumer implements Consumer{

    @KafkaListener(topics="${comment.kafka.topic}",containerFactory = "HeaderKafkaListenerContainerFactory")
    public void receiveMessage(Header header) {
        LOGGER.info("Received:"+ header);
//        Sender sender = new SenderFactory().getInstance(header.getNotificationMedium());
//        sender.send();
    }

    @Override
    public String processMessage(Header header) {
        return null;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentConsumer.class);

}
