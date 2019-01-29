package com.contest.notification.repository;

import com.contest.notification.entity.NotificationData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<NotificationData,String> {

    List<NotificationData> findByReceiver(String userId);
}
