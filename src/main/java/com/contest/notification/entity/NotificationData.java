package com.contest.notification.entity;


import com.contest.notification.dto.NotificationBodyAbstractClass;
import com.contest.notification.dto.NotificationTypeBody;
import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationEnum.NotificationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

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
    private List<NotificationMedium> notificationMedium;
    @NotNull
    private NotificationBodyAbstractClass notificationTypeBody;

    private boolean isRead = false;


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

    public List<NotificationMedium> getNotificationMedium() {
        return notificationMedium;
    }

    public void setNotificationMedium(List<NotificationMedium> notificationMedium) {
        this.notificationMedium = notificationMedium;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public NotificationBodyAbstractClass getNotificationTypeBody() {
        return notificationTypeBody;
    }

    public void setNotificationTypeBody(NotificationBodyAbstractClass notificationTypeBody) {
        this.notificationTypeBody = notificationTypeBody;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationData{");
        sb.append("notificationId='").append(notificationId).append('\'');
        sb.append(", notificationType=").append(notificationType);
        sb.append(", receiver='").append(receiver).append('\'');
        sb.append(", timeStamp='").append(timeStamp).append('\'');
        sb.append(", notificationMedium=").append(notificationMedium);
        sb.append(", notificationTypeBody=").append(notificationTypeBody);
        sb.append(", isRead=").append(isRead);
        sb.append('}');
        return sb.toString();
    }
}