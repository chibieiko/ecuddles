package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Implements exception for when item is not out of stock when attempting to subscribe for stock.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Item is not out of stock")
public class NotOutOfStockException extends RuntimeException {
}
