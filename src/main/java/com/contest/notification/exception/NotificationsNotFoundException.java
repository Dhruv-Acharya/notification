package com.contest.notification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Notifications not found.")
public class NotificationsNotFoundException extends RuntimeException {
}
