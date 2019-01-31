package com.contest.notification.service.impl;

import com.contest.notification.entity.User;
import com.contest.notification.exception.DeviceIdNotFoundException;
import com.contest.notification.exception.UserNotFoundException;
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
    public User findOne(String userId) throws UserNotFoundException{
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            return user;
        }
        else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User setAndroidDeviceId(User user, String androidDeviceId) throws DeviceIdNotFoundException{
        if (androidDeviceId != null) {
            user.setAndroidDeviceId(androidDeviceId);
            return userRepository.save(user);
        }
        else {
            throw new DeviceIdNotFoundException();
        }
    }

    @Override
    public User setBrowserDeviceId(User user, String browserDeviceId) throws DeviceIdNotFoundException{
        if (browserDeviceId != null) {
            user.setBrowserDeviceId(browserDeviceId);
            return userRepository.save(user);
        }
        else {
            throw new DeviceIdNotFoundException();
        }
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
