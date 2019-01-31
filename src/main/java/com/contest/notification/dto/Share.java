package com.contest.notification.dto;

import javax.validation.constraints.NotNull;

public class Share extends NotificationBodyAbstractClass {
    @NotNull
    private String ownerId;
    @NotNull
    private String postId;
    @NotNull
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Share{");
        sb.append("ownerId='").append(ownerId).append('\'');
        sb.append(", postId='").append(postId).append('\'');
        sb.append(", sharerId='").append(sharerId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
