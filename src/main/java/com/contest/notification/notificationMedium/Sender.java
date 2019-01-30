package com.contest.notification.notificationMedium;

import com.contest.notification.dto.Header;

public interface Sender {
    void send(Header header,String message);
}
