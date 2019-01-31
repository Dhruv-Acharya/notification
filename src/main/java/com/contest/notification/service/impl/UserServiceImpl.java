package com.contest.notification.service.impl;

import com.contest.notification.entity.User;
import com.contest.notification.repository.UserRepository;
import com.contest.notification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(String userId){
        User user = userRepository.findByUserId(userId);
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
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
