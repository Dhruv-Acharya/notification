package com.contest.notification.dto;

public class Like implements NotificationTypeBody {
    private String url;
    private String sender;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
