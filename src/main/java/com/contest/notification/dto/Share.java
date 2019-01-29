package com.contest.notification.dto;

public class Share implements NotificationTypeBody {
    private String ownerId;
    private String postId;
    private String sharerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getSharerId() {
        return sharerId;
    }

    public void setSharerId(String sharerId) {
        this.sharerId = sharerId;
    }
}
