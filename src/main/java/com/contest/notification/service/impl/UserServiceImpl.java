package com.contest.notification.service.impl;

import com.contest.notification.dto.Header;
import com.contest.notification.dto.Welcome;
import com.contest.notification.entity.User;
import com.contest.notification.notificationEnum.NotificationMedium;
import com.contest.notification.notificationEnum.NotificationType;
import com.contest.notification.notificationMedium.Mail.MailSender;
import com.contest.notification.notificationMedium.Sender;
import com.contest.notification.repository.UserRepository;
import com.contest.notification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailSender mailSender;

    @Override
    public User addUser(User user) {

        //header
        Header welcomeHeader = new Header();
        List<NotificationMedium> notificationMediumList = new ArrayList<>();
        notificationMediumList.add(NotificationMedium.EMAIL);
        welcomeHeader.setNotificationMedium(notificationMediumList);
        welcomeHeader.setNotificationType(NotificationType.WELCOME);
        welcomeHeader.setNotificationTypeBody(new Welcome());
        welcomeHeader.setReceiver(user.getUserId());
        welcomeHeader.setTimeStamp(new Date().toString());

        mailSender.send(welcomeHeader,"Hello "+ user.getUserName() +", Welcome to ScrapBook.!","Welcome to ScrapBook",user);
        return userRepository.save(user);
    }

    @Override
    public User findOne(String userId) throws Exception {
        User user = userRepository.findByUserId(userId);
        if (user==null){
            throw new Exception("User Not Found");
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User setAndroidDeviceId(User user, String androidDeviceId){
        user.setAndroidDeviceId(androidDeviceId);
        return userRepository.save(user);
    }

    @Override
    public User setBrowserDeviceId(User user, String browserDeviceId) {
        user.setBrowserDeviceId(browserDeviceId);
        return userRepository.save(user);
    }

    @Override
    public User setFacebookPreference(User user, int preference) {
        user.setFacebookPreference(preference);
        return userRepository.save(user);
    }

    @Override
    public User setContestPreference(User user, int preference) {
        user.setContestPreference(preference);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> userList= userRepository.findAll();
        if (userList.size()==0){
            throw new Exception("User Not Found");
        }
        return userList;
    }
}
