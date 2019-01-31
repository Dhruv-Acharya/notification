package com.contest.notification.service;

import com.contest.notification.entity.NotificationData;

import java.util.List;

public interface NotificationService {

    NotificationData addNotification (NotificationData notificationData);
    List<NotificationData> findByUserId(String userId);
    NotificationData findOne(String notificationId);
    Boolean markRead(NotificationData notificationData);
}
