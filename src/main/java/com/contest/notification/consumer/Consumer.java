package com.contest.notification.consumer;

import com.contest.notification.dto.Header;

public interface Consumer {
     void receiveMessage(Header header);
     String processMessage(Header header);
}
