package com.contest.notification.notificationMedium;

import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationMedium.Mail.MailSender;
import com.contest.notification.notificationMedium.Web.WebNotificationSender;
import com.contest.notification.notificationMedium.android.AndroidNotificationSender;

import java.util.List;

public class SenderFactory {
    Sender sender;
    public Sender getInstance(NotificationMedium notificationMedium){
        switch (notificationMedium){
            case WEB:
                sender = new WebNotificationSender();
                break;
            case EMAIL:
                sender = new MailSender();
                break;
            case ANDROID:
                sender = new AndroidNotificationSender();
                break;
                default:
                    sender=null;
        }
        return sender;
    }
}
