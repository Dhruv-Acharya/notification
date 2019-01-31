package com.contest.notification.notificationMedium.android;

import com.contest.notification.dto.Header;
import com.contest.notification.entity.User;
import com.contest.notification.notificationMedium.Mail.MailSender;
import com.contest.notification.notificationMedium.Sender;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "AndroidTopicNotificationSender")
public class AndroidTopicNotificationSender implements Sender {


    @Override
    public void send(Header header, String message, String title, User user) {

        Message message1 = Message.builder()
                .setNotification(new Notification(title,message))
                .setTopic("contest")
                .build();
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message1);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully sent message: " + response);

    }
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSender.class);

}
