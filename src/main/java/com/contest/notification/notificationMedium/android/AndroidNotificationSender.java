package com.contest.notification.notificationMedium.android;

import com.contest.notification.dto.Header;
import com.contest.notification.entity.User;
import com.contest.notification.notificationMedium.Mail.MailSender;
import com.contest.notification.notificationMedium.Sender;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service(value = "AndroidNotificationSender")
public class AndroidNotificationSender implements Sender {


    @Override
    public void send(Header header, String message, String title, User user) {
        LOGGER.info("Android header:{}",header.toString());
        LOGGER.info("title:{}",title);
        LOGGER.info("User:{}",user.toString());
        LOGGER.info("message:{}",message);

        String tokenId = user.getAndroidDeviceId();
        Message message1 = Message.builder()
                .setNotification(new Notification(title,message))
                .setToken(tokenId)
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
