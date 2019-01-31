package com.contest.notification.consumer;

import com.contest.notification.dto.Follow;
import com.contest.notification.dto.Generic;
import com.contest.notification.dto.Header;
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
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Service
public class GenericConsumer implements Consumer {

    @Autowired
    TemplateService templateService;

    @Autowired
    UserService userService;

    @Autowired
    SenderFactory senderFactory;

    @Autowired
    NotificationService notificationService;

    @KafkaListener(topics="${generic.kafka.topic}",containerFactory = "HeaderKafkaListenerContainerFactory")
    public void receiveMessage(Header header) throws Exception {

        LOGGER.info("Received:"+ header);

        if(header == null)
            throw new FieldsCanNotBeEmpty("Header Cannot Be Empty");

        if(header.getReceiver() == null || header.getNotificationMedium() == null || header.getNotificationType() == null ||
                header.getNotificationTypeBody() == null || header.getTimeStamp() == null)
            throw new FieldsCanNotBeEmpty("Header Fields Cannot Be Empty");

        Generic generic = (Generic) header.getNotificationTypeBody();

        if(generic.getMessage() == null){
            throw new FieldsCanNotBeEmpty("Notification Body Fields Cannot Be Empty");
        }

        User user= userService.findOne(header.getReceiver());
        for (NotificationMedium medium: header.getNotificationMedium()) {
            Sender sender = senderFactory.getInstance(medium);
            sender.send(header,processMessage(header),"Notification",user);
        }

        NotificationData notificationData = new NotificationData();
        BeanUtils.copyProperties(header,notificationData);
        notificationData.setNotificationTypeBody(header.getNotificationTypeBody());
        notificationService.addNotification(notificationData);
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
