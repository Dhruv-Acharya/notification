package com.contest.notification.notificationMedium;

import com.contest.notification.dto.Header;
import com.contest.notification.entity.User;

public interface Sender {
    void send(Header header,String message,String subject, User user);
}
