package com.contest.notification.service.impl;

import com.contest.notification.entity.NotificationData;
import com.contest.notification.entity.Template;
import com.contest.notification.exception.NotificationsNotFoundException;
import com.contest.notification.repository.NotificationRepository;
import com.contest.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public NotificationData addNotification(NotificationData notificationData) {
        return notificationRepository.save(notificationData);
    }

    @Override
    public List<NotificationData> findByUserId(String userId) throws NotificationsNotFoundException{
        List<NotificationData> notifications = notificationRepository.findByReceiver(userId);
        if (notifications == null) {
            throw new NotificationsNotFoundException();
        }
        return notifications;
    }
}
