package com.contest.notification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Notification Medium must not be null.")
public class NotificationMediumNotFoundException extends RuntimeException {
}
