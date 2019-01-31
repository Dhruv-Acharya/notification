package com.contest.notification.consumer;

import com.contest.notification.dto.Contest;
import com.contest.notification.dto.Header;
import com.contest.notification.entity.Template;
import com.contest.notification.entity.User;
import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationMedium.Sender;
import com.contest.notification.notificationMedium.SenderFactory;
import com.contest.notification.notificationMedium.Web.WebTopicNotificationSender;
import com.contest.notification.notificationMedium.android.AndroidTopicNotificationSender;
import com.contest.notification.service.TemplateService;
import com.contest.notification.service.UserService;
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

    @Autowired
    AndroidTopicNotificationSender androidTopicNotificationSender;

    @Autowired
    UserService userService;

    @Autowired
    SenderFactory senderFactory;

    @Autowired
    WebTopicNotificationSender webTopicNotificationSender;


    @KafkaListener(topics="${contest.kafka.topic}",containerFactory = "HeaderKafkaListenerContainerFactory")
    public void receiveMessage(Header header) {
        LOGGER.info("Received:"+ header);
        User user= null;
        for (NotificationMedium medium: header.getNotificationMedium()) {
            if (medium == NotificationMedium.ANDROID){
                Sender sender = androidTopicNotificationSender;
                sender.send(header,processMessage(header),"Contest Added",user);
            }
            else if (medium == NotificationMedium.EMAIL){
                for (User existingUser :userService.findAll()) {
                    Sender sender = new SenderFactory().getInstance(medium);
                    sender.send(header,processMessage(header),"Contest Added",existingUser);
                }
            }
            else if (medium == NotificationMedium.WEB){
                Sender sender = webTopicNotificationSender;
                sender.send(header,processMessage(header),"Contest Added",user);
            }
        }
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
