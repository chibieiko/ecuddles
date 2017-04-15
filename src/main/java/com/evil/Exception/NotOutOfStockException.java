package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vili on 15/04/2017.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Item is not out of stock")
public class NotOutOfStockException extends RuntimeException {
}
