package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Implements exception for when item is out of stock when attempting to add it to cart or checkout.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="One or more items have quantity exceeding the stock")
public class OutOfStockException extends RuntimeException {
}
