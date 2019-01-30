package com.contest.notification.dto;

import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationEnum.NotificationType;

import java.util.List;

public class NotificationDataDTO {
    private String notificationId;
    private NotificationType notificationType;
    private String receiver;
    private String timeStamp;
    private List<NotificationMedium> notificationMedium;
    private NotificationTypeBody notificationTypeBody;
    private boolean isRead = false;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<NotificationMedium> getNotificationMedium() {
        return notificationMedium;
    }

    public void setNotificationMedium(List<NotificationMedium> notificationMedium) {
        this.notificationMedium = notificationMedium;
    }

    public NotificationTypeBody getNotificationTypeBody() {
        return notificationTypeBody;
    }

    public void setNotificationTypeBody(NotificationTypeBody notificationTypeBody) {
        this.notificationTypeBody = notificationTypeBody;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
