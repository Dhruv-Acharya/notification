package com.contest.notification.consumer;


import com.contest.notification.dto.Header;
import com.contest.notification.dto.Result;
import com.contest.notification.entity.User;
import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationMedium.Sender;
import com.contest.notification.notificationMedium.SenderFactory;
import com.contest.notification.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ResultConsumer implements Consumer{
    @Autowired
    UserService userService;

    @Autowired
    SenderFactory senderFactory;


    @KafkaListener(topics="${result.kafka.topic}",containerFactory = "HeaderKafkaListenerContainerFactory")
    public void receiveMessage(Header header) {
        LOGGER.info("Received:"+ header);
        User user= userService.findOne(header.getReceiver());
        for (NotificationMedium medium: header.getNotificationMedium()) {
            Sender sender = senderFactory.getInstance(medium);
            sender.send(header,processMessage(header),"LeaderBoard Updated",user);
        }
    }

    @Override
    public String processMessage(Header header) {
        Result result = (Result)header.getNotificationTypeBody();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi ");
        stringBuilder.append(userService.findOne(header.getReceiver()).getUserName());
        stringBuilder.append("\nYour result for ");
        stringBuilder.append(result.getContest().getContestName());
        stringBuilder.append(" is ");
        stringBuilder.append(result.getScore());
        stringBuilder.append(" and your rank is "+result.getRank()+".");
        stringBuilder.append("\n\n Thanks for participating!");
        return stringBuilder.toString();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultConsumer.class);

}
