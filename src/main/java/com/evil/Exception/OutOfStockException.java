package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vili on 15/04/2017.
 */
@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="One or more items have quantity exceeding the stock")
public class OutOfStockException extends RuntimeException {
}
