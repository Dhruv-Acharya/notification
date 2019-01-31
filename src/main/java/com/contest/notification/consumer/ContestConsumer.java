package com.contest.notification.consumer;

import com.contest.notification.dto.Contest;
import com.contest.notification.dto.Header;
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
public class ContestConsumer implements Consumer{

    @Autowired
    TemplateService templateService;


    @KafkaListener(topics="${contest.kafka.topic}",containerFactory = "HeaderKafkaListenerContainerFactory")
    public void receiveMessage(Header header) {
        LOGGER.info("Received:"+ header);

    }

    @Override
    public String processMessage(Header header) {

        Template template = templateService.findByTemplateName(header.getNotificationType().getValue());

        String str = template.getTemplate();
        int endIndex = 0;

        List<String> replacementArray = new ArrayList<>();
        Contest contest = (Contest)header.getNotificationTypeBody();
        replacementArray.add(contest.getContestName());

        int i=0;
        LOGGER.info("Template : {}" , str);
        while(true) {

            int startIndex = str.indexOf("<",endIndex);
            if(startIndex == -1)
                break;
            endIndex = str.indexOf(">",endIndex);

            String replaceString = str.substring(startIndex, ++endIndex);
            //System.out.println(replaceString);
            if(replacementArray.size() > i) {
                str = str.replace(replaceString, replacementArray.get(i++));
                // System.out.println("Result : " + str);
            }

        }
        LOGGER.info("Final String : {}" , str);
        return str;
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(ContestConsumer.class);
}
