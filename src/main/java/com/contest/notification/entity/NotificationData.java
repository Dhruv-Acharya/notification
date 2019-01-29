package com.contest.notification.entity;


import com.contest.notification.dto.NotificationTypeBody;
import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationEnum.NotificationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = NotificationData.COLLECTION_NAME )
public class NotificationData {

    public static final String COLLECTION_NAME = "notificationdata";
    @Id
    private String notificationId;
    @NotNull
    private NotificationType notificationType;
    @NotNull
    private String receiver;
    @NotNull
    private String timeStamp;
    @NotNull
    private NotificationMedium notificationMedium;
    @NotNull
    private NotificationTypeBody notificationTypeBody;

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

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

    public NotificationMedium getNotificationMedium() {
        return notificationMedium;
    }

    public void setNotificationMedium(NotificationMedium notificationMedium) {
        this.notificationMedium = notificationMedium;
    }

    public NotificationTypeBody getNotificationTypeBody() {
        return notificationTypeBody;
    }

    public void setNotificationTypeBody(NotificationTypeBody notificationTypeBody) {
        this.notificationTypeBody = notificationTypeBody;
    }
}