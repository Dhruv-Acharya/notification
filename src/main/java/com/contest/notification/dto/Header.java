package com.contest.notification.dto;

public class Header {
    private int notificationType;
    private String receiver;
    private String timeStamp;
    private String type;
    private NotificationTypeBody notificationTypeBody;

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NotificationTypeBody getNotificationTypeBody() {
        return notificationTypeBody;
    }

    public void setNotificationTypeBody(NotificationTypeBody notificationTypeBody) {
        this.notificationTypeBody = notificationTypeBody;
    }
}
