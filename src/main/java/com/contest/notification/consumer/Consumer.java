package com.contest.notification.consumer;

import com.contest.notification.dto.Header;
import com.contest.notification.exception.FieldsCanNotBeEmpty;

public interface Consumer {
     void receiveMessage(Header header) throws Exception;
     String processMessage(Header header) throws Exception;
}
