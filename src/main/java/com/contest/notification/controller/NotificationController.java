package com.contest.notification.controller;


import com.contest.notification.dto.NotificationDataDTO;
import com.contest.notification.entity.NotificationData;
import com.contest.notification.service.NotificationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> addNotification(@RequestBody NotificationDataDTO notificationDataDTO) {
        NotificationData notificationData = new NotificationData();
        BeanUtils.copyProperties(notificationDataDTO, notificationData);
        if (notificationData.getNotificationType() == null) {
            throw new NotificationTypeNotFoundException();
        }
        if (notificationData.getNotificationMedium() == null) {
            throw new NotificationMediumNotFoundException();
        }
        if (notificationData.getNotificationType() == null) {
            throw new NotificationTypeBodyNotFoundException();
        }
        if (notificationData.getReceiver() == null) {
            throw new ReceiverNotFoundException();
        }
        if (notificationData.getTimeStamp() == null) {
            throw new TimestampNotFoundException();
        }

        NotificationData notificationDataCreated = notificationService.addNotification(notificationData);
        return new ResponseEntity<>(notificationDataCreated.getNotificationId(),HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<NotificationData>> findByUserId(@PathVariable(value = "userId") String userId) {
         return new ResponseEntity<>(notificationService.findByUserId(userId),HttpStatus.OK);
    }

    @RequestMapping(value = "/markRead/{notificationId}", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> markRead(@PathVariable(value = "notificationId") String notificationId) {
        NotificationData notificationData = notificationService.findOne(notificationId);
        if (notificationService.markRead(notificationData)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }
}
