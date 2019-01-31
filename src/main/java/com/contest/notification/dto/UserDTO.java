package com.contest.notification.dto;

public class UserDTO {
    private String userId;
    private String userName;
    private String emailId;
    private String androidDeviceId;
    private String browserDeviceId;
    private int facebookPreference;
    private int contestPreference;
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
}
