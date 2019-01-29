package com.contest.notification.dto;

public class Follow implements NotificationTypeBody {
    private String sender;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
