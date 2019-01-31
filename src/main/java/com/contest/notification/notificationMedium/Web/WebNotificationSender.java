package com.contest.notification.notificationMedium.Web;

import com.contest.notification.dto.Header;
import com.contest.notification.entity.User;
import com.contest.notification.notificationMedium.Sender;
import org.springframework.stereotype.Service;

@Service(value = "WebNotificationSender")
public class WebNotificationSender implements Sender {

    @Override
    public void send(Header header, String message, String subject, User user) {
        if (user.getBrowserDeviceId()==null){
            return;
        }
    }
}
