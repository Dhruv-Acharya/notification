package com.contest.notification.dto;

public class Follow implements NotificationTypeBody {
    private String sender;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Follow{");
        sb.append("sender='").append(sender).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
