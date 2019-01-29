package com.contest.notification.listener;

import com.contest.notification.dto.Header;

public interface Consumer {
    public void receiveMessage(Header header);
    public String processMessage(Header header);
}
