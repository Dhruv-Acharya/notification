package com.contest.notification.dto;

import java.util.List;

public class NotificationDTO {
    private boolean status;
    private String message;
    private List<NotificationHistoryDTO> notificationHistoryDTOList;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<NotificationHistoryDTO> getNotificationHistoryDTOList() {
        return notificationHistoryDTOList;
    }

    public void setNotificationHistoryDTOList(List<NotificationHistoryDTO> notificationHistoryDTOList) {
        this.notificationHistoryDTOList = notificationHistoryDTOList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NotificationDTO{");
        sb.append("status=").append(status);
        sb.append(", message='").append(message).append('\'');
        sb.append(", notificationHistoryDTOList=").append(notificationHistoryDTOList);
        sb.append('}');
        return sb.toString();
    }
}
