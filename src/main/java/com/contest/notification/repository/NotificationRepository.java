package com.contest.notification.repository;

import com.contest.notification.entity.NotificationData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<NotificationData,String> {
}
