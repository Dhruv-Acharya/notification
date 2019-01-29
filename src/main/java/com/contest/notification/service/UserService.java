package com.contest.notification.service;

import com.contest.notification.entity.User;

public interface UserService {
    User addUser(User user);
    User findOne(String userId);
    User updateUser(User user);
}
