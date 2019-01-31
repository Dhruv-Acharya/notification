package com.contest.notification.notificationMedium;

import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationMedium.Mail.MailSender;
import com.contest.notification.notificationMedium.Web.WebNotificationSender;
import com.contest.notification.notificationMedium.android.AndroidNotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public class SenderFactory {


    @Autowired
    @Qualifier("AndroidNotificationSender")
    Sender androidSender;

    @Autowired
    @Qualifier("MailSender")
    Sender mailSender;

    @Autowired
    @Qualifier("WebNotificationSender")
    Sender webSender;


    public Sender getInstance(NotificationMedium notificationMedium){
        switch (notificationMedium){
            case WEB:
                return webSender;
            case EMAIL:
                return mailSender;
            case ANDROID:
                return androidSender;
                default:
                    return null;
        }

    }
}
