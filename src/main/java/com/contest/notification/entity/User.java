package com.contest.notification.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document(collection = User.COLLECTION_NAME)
public class User {

    public static final String COLLECTION_NAME = "user";

    @Id
    @NotNull
    private String userId;
    @NotNull
    private String userName;
    @NotNull
    private String emailId;
    private String androidDeviceId;
    private String browserDeviceId;
    private int facebookPreference;
    private int contestPreference;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAndroidDeviceId() {
        return androidDeviceId;
    }

    public void setAndroidDeviceId(String androidDeviceId) {
        this.androidDeviceId = androidDeviceId;
    }

    public String getBrowserDeviceId() {
        return browserDeviceId;
    }

    public void setBrowserDeviceId(String browserDeviceId) {
        this.browserDeviceId = browserDeviceId;
    }

    public int getFacebookPreference() {
        return facebookPreference;
    }

    public void setFacebookPreference(int facebookPreference) {
        this.facebookPreference = facebookPreference;
    }

    public int getContestPreference() {
        return contestPreference;
    }

    public void setContestPreference(int contestPreference) {
        this.contestPreference = contestPreference;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", androidDeviceId='" + androidDeviceId + '\'' +
                ", browserDeviceId='" + browserDeviceId + '\'' +
                ", facebookPreference=" + facebookPreference +
                ", contestPreference=" + contestPreference +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getFacebookPreference() == user.getFacebookPreference() &&
                getContestPreference() == user.getContestPreference() &&
                Objects.equals(getUserId(), user.getUserId()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getEmailId(), user.getEmailId()) &&
                Objects.equals(getAndroidDeviceId(), user.getAndroidDeviceId()) &&
                Objects.equals(getBrowserDeviceId(), user.getBrowserDeviceId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserId(), getUserName(), getEmailId(), getAndroidDeviceId(), getBrowserDeviceId(), getFacebookPreference(), getContestPreference());
    }
}
