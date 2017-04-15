package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vili on 15/04/2017.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Notification already set for this item")
public class DuplicateNotificationException extends RuntimeException {
}

