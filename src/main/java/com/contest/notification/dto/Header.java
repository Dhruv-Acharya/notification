package com.contest.notification.dto;

import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationEnum.NotificationType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Header {
    @NotNull
    private NotificationType notificationType;
    @NotNull
    private String receiver;
    @NotNull
    private String timeStamp;
    @NotEmpty
    private List<NotificationMedium> notificationMedium;
    @NotNull
    private NotificationBodyAbstractClass notificationTypeBody;

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public List<NotificationMedium> getNotificationMedium() {
        return notificationMedium;
    }

    public void setNotificationMedium(List<NotificationMedium> notificationMedium) {
        this.notificationMedium = notificationMedium;
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

    public NotificationBodyAbstractClass getNotificationTypeBody() {
        return notificationTypeBody;
    }

    public void setNotificationTypeBody(NotificationBodyAbstractClass notificationTypeBody) {
        this.notificationTypeBody = notificationTypeBody;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Header{");
        sb.append("notificationType=").append(notificationType);
        sb.append(", receiver='").append(receiver).append('\'');
        sb.append(", timeStamp='").append(timeStamp).append('\'');
        sb.append(", notificationMedium=").append(notificationMedium);
        sb.append(", notificationTypeBody=").append(notificationTypeBody);
        sb.append('}');
        return sb.toString();
    }
}
