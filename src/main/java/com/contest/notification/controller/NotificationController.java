package com.contest.notification.controller;


import com.contest.notification.dto.NotificationDTO;
import com.contest.notification.dto.NotificationDataDTO;
import com.contest.notification.dto.NotificationHistoryDTO;
import com.contest.notification.entity.NotificationData;
import com.contest.notification.service.NotificationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/notification")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> addNotification(@RequestBody NotificationDataDTO notificationDataDTO) {
        NotificationData notificationData = new NotificationData();
        BeanUtils.copyProperties(notificationDataDTO, notificationData);
        NotificationData notificationDataCreated = notificationService.addNotification(notificationData);
        return new ResponseEntity<>(notificationDataCreated.getNotificationId(),HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<NotificationDTO> findByUserId(@PathVariable(value = "userId") String userId) throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO();

        List<NotificationHistoryDTO> notificationHistoryDTOList= notificationService.findByUserId(userId);
        if (notificationHistoryDTOList.size()==0){
            notificationDTO.setStatus(false);
            notificationDTO.setMessage("No notifications found.");
            notificationDTO.setNotificationHistoryDTOList(notificationHistoryDTOList);
            return new ResponseEntity<>(notificationDTO,HttpStatus.OK);
        }
        notificationDTO.setStatus(true);
        notificationDTO.setMessage("success");
        notificationDTO.setNotificationHistoryDTOList(notificationHistoryDTOList);
        return new ResponseEntity<>(notificationDTO,HttpStatus.OK);
    }
    @RequestMapping(value = "/{userId}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<NotificationDTO> findByUserIdPageable(@PathVariable(value = "userId") String userId, @PathVariable(value = "pageSize")int pageSize) throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO();

        List<NotificationHistoryDTO> notificationHistoryDTOList= notificationService.findByUserIdPagenation(userId,pageSize);
        if (notificationHistoryDTOList.size()==0){
            notificationDTO.setStatus(false);
            notificationDTO.setMessage("No notifications found.");
            notificationDTO.setNotificationHistoryDTOList(notificationHistoryDTOList);
            return new ResponseEntity<>(notificationDTO,HttpStatus.OK);
        }
        notificationDTO.setStatus(true);
        notificationDTO.setMessage("success");
        notificationDTO.setNotificationHistoryDTOList(notificationHistoryDTOList);
        return new ResponseEntity<>(notificationDTO,HttpStatus.OK);
    }
    @CrossOrigin("*")
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
