package com.contest.notification.dto;

import com.contest.notification.notificationEnum.PostComment;

public class Like implements NotificationTypeBody {
    private String postId;
    private String sender;
    private PostComment postComment;

    public PostComment getPostComment() {
        return postComment;
    }

    public void setPostComment(PostComment postComment) {
        this.postComment = postComment;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
