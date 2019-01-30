package com.contest.notification.notificationMedium.android;

import com.contest.notification.dto.Header;
import com.contest.notification.entity.User;
import com.contest.notification.notificationMedium.Sender;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service
public class AndroidNotificationSender implements Sender {
    public static final String TOPIC = "JavaSampleApproach";

    @Autowired
    AndroidPushNotificationService androidPushNotificationService;

    @Override
    public void send(Header header, String message, String title, User user) {
        JSONObject body  = new JSONObject();
        try {
            body.put("to", user.getAndroidDeviceId());
            body.put("priority", "high");

        } catch (JSONException e) {
            e.printStackTrace();
        }



        JSONObject notification = new JSONObject();
        try {
            notification.put("title", title);
            notification.put("body", message);



            body.put("notification", notification);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationService.send(request);
        CompletableFuture.allOf(pushNotification).join();

    }
}
