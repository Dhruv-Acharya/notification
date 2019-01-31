package com.contest.notification.service;

import com.contest.notification.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User findOne(String userId) throws Exception;
    User updateUser(User user);
    List<User> findAll() throws Exception;
    User setAndroidDeviceId(User user, String androidDeviceId);
    User setBrowserDeviceId(User user, String browserDeviceId);
    User setFacebookPreference(User user, int preference);
    User setContestPreference(User user, int preference);
}
