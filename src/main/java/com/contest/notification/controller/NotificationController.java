package com.contest.notification.controller;


import com.contest.notification.dto.NotificationDataDTO;
import com.contest.notification.entity.NotificationData;
import com.contest.notification.service.NotificationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping
    public ResponseEntity<String> addNotification(NotificationDataDTO notificationDataDTO) {
        NotificationData notificationData = new NotificationData();
        BeanUtils.copyProperties(notificationDataDTO, notificationData);
        NotificationData notificationDataCreated = notificationService.addNotification(notificationData);
        return new ResponseEntity<>(notificationDataCreated.getNotificationId(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<NotificationData>> findByUserId(String userId) {
         return new ResponseEntity<>(notificationService.findByUserId(userId),HttpStatus.OK);
    }

}
