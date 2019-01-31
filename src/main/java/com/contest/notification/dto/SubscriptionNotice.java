package com.contest.notification.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class SubscriptionNotice extends NotificationBodyAbstractClass{
    @NotEmpty
    List<String> followerIds;
    @NotNull
    private String contestId;
    @NotNull
    private String contestName;

    public List<String> getFollowerIds() {
        return followerIds;
    }

    public void setFollowerIds(List<String> followerIds) {
        this.followerIds = followerIds;
    }

    public String getContestId() {
        return contestId;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubscriptionNotice{");
        sb.append("followerIds=").append(followerIds);
        sb.append('}');
        return sb.toString();
    }
}
