package com.contest.notification.notificationEnum;

public enum NotificationMedium {
    EMAIL(0),
    WEB(1),
    ANDROID(2);

    final int value;

    NotificationMedium(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
