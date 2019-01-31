package com.contest.notification.dto;

public class Contest extends NotificationBodyAbstractClass {

    private String contestId;
    private String contestName;

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
        final StringBuilder sb = new StringBuilder("Contest{");
        sb.append("contestId='").append(contestId).append('\'');
        sb.append(", contestName='").append(contestName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
