package com.contest.notification.service;

import com.contest.notification.dto.NotificationHistoryDTO;
import com.contest.notification.entity.NotificationData;

import java.util.List;

public interface NotificationService {

    NotificationData addNotification (NotificationData notificationData);
    List<NotificationHistoryDTO> findByUserId(String userId);
    NotificationData findOne(String notificationId);
    Boolean markRead(NotificationData notificationData);
}
