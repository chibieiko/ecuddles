package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0415
 * @since 1.7
 */

@ResponseStatus(value= HttpStatus.BAD_REQUEST,
        reason="No reviews exist.")
public class NoReviewsException extends RuntimeException {
}
