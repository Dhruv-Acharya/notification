package com.contest.notification.service.impl;

import com.contest.notification.consumer.*;
import com.contest.notification.dto.*;
import com.contest.notification.entity.NotificationData;
import com.contest.notification.repository.NotificationRepository;
import com.contest.notification.service.NotificationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    FollowConsumer followConsumer;

    @Autowired
    LikeConsumer likeConsumer;

    @Autowired
    CommentConsumer commentConsumer;

    @Autowired
    WelcomeConsumer welcomeConsumer;

    @Autowired
    ContestConsumer contestConsumer;

    @Autowired
    GenericConsumer genericConsumer;

    @Autowired
    QuestionsConsumer questionsConsumer;

    @Autowired
    ResultConsumer resultConsumer;

    @Autowired
    SubscriptionNoticeConsumer subscriptionNoticeConsumer;

    @Autowired
    ShareConsumer shareConsumer;


    @Override
    public NotificationData addNotification(NotificationData notificationData) {
        return notificationRepository.save(notificationData);
    }

    @Override
    public List<NotificationHistoryDTO> findByUserId(String userId) throws Exception {
        List<NotificationData> notifications = notificationRepository.findByReceiver(userId);

        List<NotificationHistoryDTO> notificationHistoryDTOList = new ArrayList<>();
        for ( NotificationData singleNotification: notifications) {

            NotificationHistoryDTO notificationHistoryDTO= new NotificationHistoryDTO();
            notificationHistoryDTO.setNotificationId(singleNotification.getNotificationId());
            notificationHistoryDTO.setRead(singleNotification.isRead());
            notificationHistoryDTO.setNotificationType(singleNotification.getNotificationType());
            notificationHistoryDTO.setTimeStamp(singleNotification.getTimeStamp());

            Header header = new Header();
            BeanUtils.copyProperties(singleNotification,header);
            header.setNotificationTypeBody(singleNotification.getNotificationTypeBody());

            String message = null;

            switch (singleNotification.getNotificationType()){


                case FOLLOW:
                    message = followConsumer.processMessage(header);
                    Follow follow = (Follow) header.getNotificationTypeBody();
                    notificationHistoryDTO.setUrl(follow.getSender());
                    break;

                case LIKE:
                    message = likeConsumer.processMessage(header);
                    Like like = (Like) header.getNotificationTypeBody();
                    notificationHistoryDTO.setUrl(like.getPostId());
                    break;

                case COMMENT:
                    message = commentConsumer.processMessage(header);
                    Comment comment = (Comment) header.getNotificationTypeBody();
                    notificationHistoryDTO.setUrl(comment.getPostId());
                    break;

                case WELCOME:
                    message = welcomeConsumer.processMessage(header);
                    notificationHistoryDTO.setUrl("");
                    break;

                case CONTEST:
                    message = contestConsumer.processMessage(header);
                    Contest contest = (Contest) header.getNotificationTypeBody();
                    notificationHistoryDTO.setUrl(contest.getContestId());
                    break;

                case GENERIC:
                    message = genericConsumer.processMessage(header);
                    notificationHistoryDTO.setUrl("");
                    break;

                case QUESTIONS_ADDED:
                    message = questionsConsumer.processMessage(header);
                    notificationHistoryDTO.setUrl("");
                    break;

                case RESULT:
                    message = resultConsumer.processMessage(header);
                    Result result = (Result) header.getNotificationTypeBody();
                    notificationHistoryDTO.setUrl(result.getUserId());
                    break;

                case SUBSCRIPTION_NOTICE:
                    message = subscriptionNoticeConsumer.processMessage(header);
                    notificationHistoryDTO.setUrl(header.getReceiver());
                    break;

                case SHARE:
                    message = shareConsumer.processMessage(header);
                    Share share = (Share) header.getNotificationTypeBody();
                    notificationHistoryDTO.setUrl(share.getPostId());
                    break;
            }

            notificationHistoryDTO.setMessage(message);
            notificationHistoryDTOList.add(notificationHistoryDTO);

        }


        return notificationHistoryDTOList;

    }

    @Override
    public NotificationData findOne(String notificationId) {
        return notificationRepository.findOne(notificationId);
    }

    @Override
    public Boolean markRead(NotificationData notificationData) {
        notificationData.setRead(true);
        NotificationData updatedNotificationData = notificationRepository.save(notificationData);
        if (updatedNotificationData == null) {
            return false;
        }
        else {
            return true;
        }
    }
}
