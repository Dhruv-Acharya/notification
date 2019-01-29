package com.contest.notification.dto;

public class Result implements NotificationTypeBody {
    private String userId;
    private double score;
    private String rank;
    private String url;
    private Contest contest;

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Result{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", score=").append(score);
        sb.append(", rank='").append(rank).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", contest=").append(contest);
        sb.append('}');
        return sb.toString();
    }
}
