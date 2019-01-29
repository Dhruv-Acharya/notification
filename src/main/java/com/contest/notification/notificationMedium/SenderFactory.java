package com.contest.notification.notificationMedium;

import com.contest.notification.notificationEnum.NotificationMedium;

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
