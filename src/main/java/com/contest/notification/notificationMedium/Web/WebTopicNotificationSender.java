package com.contest.notification.notificationMedium.Web;

import com.contest.notification.dto.Header;
import com.contest.notification.entity.User;
import com.contest.notification.notificationMedium.Sender;
import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

@Service(value = "WebNotificationSender")
public class WebTopicNotificationSender implements Sender {

    @Override
    public void send(Header header, String message, String subject, User user) {
        Message messageFCM = Message.builder()
                .setWebpushConfig(WebpushConfig.builder()
                        .setNotification(new WebpushNotification(
                                subject,
                                message
                                ))
                        .build())
                .setTopic("${firebase.topic.contest}")
                .build();
        try {
            String response = FirebaseMessaging.getInstance().send(messageFCM);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }


    }
}
