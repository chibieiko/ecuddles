package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Implements exception for when user tries to delete review that does not exist.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST,
        reason="No reviews exist.")
public class NoReviewsException extends RuntimeException {
}
