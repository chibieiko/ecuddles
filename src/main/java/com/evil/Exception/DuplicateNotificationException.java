package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Implements exception for when user already has subscribed for a product stock.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Notification already set for this item")
public class DuplicateNotificationException extends RuntimeException {
}

