package com.contest.notification.consumer;


import com.contest.notification.dto.Header;
import com.contest.notification.dto.Like;
import com.contest.notification.entity.Template;
import com.contest.notification.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsConsumer implements Consumer{

    @Autowired
    TemplateService templateService;

    @KafkaListener(topics="${questionAdded.kafka.topic}",containerFactory = "HeaderKafkaListenerContainerFactory")
    public void receiveMessage(Header header) {
        LOGGER.info("Received:"+ header);
    }

    @Override
    public String processMessage(Header header) {

        Template template = templateService.findByTemplateName(header.getNotificationType().getValue());
        String str = template.getTemplate();
        LOGGER.info("Final String : {}" , str);
        return str;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionsConsumer.class);

}
