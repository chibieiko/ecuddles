package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Implements exception for when user already has submitted a review for product.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@ResponseStatus(value= HttpStatus.FORBIDDEN,
        reason="User has already submitted a review for this product")
public class IllegalReviewException extends RuntimeException {

}
