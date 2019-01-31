package com.contest.notification.dto;

import com.contest.notification.notificationEnum.NotificationType;

public class NotificationHistoryDTO {

    private String notificationId;
    private String message;
    private boolean isRead;
    private String url;
    private NotificationType notificationType;

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationHistoryDTO{");
        sb.append("notificationId='").append(notificationId).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", isRead=").append(isRead);
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
