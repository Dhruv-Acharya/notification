package com.contest.notification.consumer;

import com.contest.notification.dto.Follow;
import com.contest.notification.dto.Generic;
import com.contest.notification.dto.Header;
import com.contest.notification.entity.Template;
import com.contest.notification.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class GenericConsumer implements Consumer {

    @Autowired
    TemplateService templateService;

    @KafkaListener(topics="${generic.kafka.topic}",containerFactory = "HeaderKafkaListenerContainerFactory")
    public void receiveMessage(Header header) {
        LOGGER.info("Received:"+ header);
    }

    @Override
    public String processMessage(Header header) {

        Generic generic = (Generic)header.getNotificationTypeBody();
        String str = generic.getMessage();
        LOGGER.info("Final String : {}" , str);
        return str;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericConsumer.class);

}
