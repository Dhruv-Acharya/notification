package com.contest.notification.consumer;


import com.contest.notification.dto.Header;
import com.contest.notification.dto.Like;
import com.contest.notification.dto.Share;
import com.contest.notification.entity.NotificationData;
import com.contest.notification.entity.Template;
import com.contest.notification.entity.User;
import com.contest.notification.exception.FieldsCanNotBeEmpty;
import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationMedium.Sender;
import com.contest.notification.notificationMedium.SenderFactory;
import com.contest.notification.service.NotificationService;
import com.contest.notification.service.TemplateService;
import com.contest.notification.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShareConsumer implements Consumer{

    @Autowired
    TemplateService templateService;

    @Autowired
    UserService userService;

    @Autowired
    SenderFactory senderFactory;

    @Autowired
    NotificationService notificationService;

    @KafkaListener(topics="${share.kafka.topic}",containerFactory = "HeaderKafkaListenerContainerFactory")
    public void receiveMessage(Header header) throws FieldsCanNotBeEmpty {
        LOGGER.info("Received:"+ header);

        if(header == null)
            throw new FieldsCanNotBeEmpty("Header Cannot Be Empty");

        if(header.getReceiver() == null || header.getNotificationMedium() == null || header.getNotificationType() == null ||
                header.getNotificationTypeBody() == null || header.getTimeStamp() == null)
            throw new FieldsCanNotBeEmpty("Header Fields Cannot Be Empty");

        Share share = (Share) header.getNotificationTypeBody();

        if(share.getOwnerId() == null || share.getPostId() == null || share.getSharerId() == null){
            throw new FieldsCanNotBeEmpty("Notification Body Fields Cannot Be Empty");
        }


        User user= userService.findOne(header.getReceiver());
        for (NotificationMedium medium: header.getNotificationMedium()) {
            Sender sender = senderFactory.getInstance(medium);
            sender.send(header,processMessage(header),"Shared",user);
        }

        NotificationData notificationData = null;
        BeanUtils.copyProperties(header,notificationData);
        notificationService.addNotification(notificationData);
    }

    @Override
    public String processMessage(Header header) {

        Template template = templateService.findByTemplateName(header.getNotificationType().getValue());

        String str = template.getTemplate();
        int endIndex = 0;

        List<String> replacementArray = new ArrayList<>();
        Share share = (Share)header.getNotificationTypeBody();
        User user = userService.findOne(share.getSharerId());
        replacementArray.add(user.getUserName());

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

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareConsumer.class);

}
