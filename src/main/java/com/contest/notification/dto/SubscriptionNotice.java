package com.contest.notification.dto;

import java.util.List;

public class SubscriptionNotice implements NotificationTypeBody{
    List<String> followerIds;

    public List<String> getFollowerIds() {
        return followerIds;
    }

    public void setFollowerIds(List<String> followerIds) {
        this.followerIds = followerIds;
    }
}
