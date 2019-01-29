package com.contest.notification.service.impl;

import com.contest.notification.entity.NotificationData;
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
    public NotificationData add(NotificationData notificationData) {
        return notificationRepository.save(notificationData);
    }

    @Override
    public List<NotificationData> findByUserId(String userId) {
        return notificationRepository.findByUserId(userId);
    }


}
