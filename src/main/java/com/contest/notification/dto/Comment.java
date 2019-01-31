package com.contest.notification.dto;

import com.contest.notification.notificationEnum.PostComment;

import javax.validation.constraints.NotNull;

public class Comment extends NotificationBodyAbstractClass {
    @NotNull(message = "Post ID can not be null")
    private String postId;
    @NotNull
    private String commenter;
    @NotNull
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

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("postId='").append(postId).append('\'');
        sb.append(", commenter='").append(commenter).append('\'');
        sb.append(", postComment=").append(postComment);
        sb.append('}');
        return sb.toString();
    }
}
