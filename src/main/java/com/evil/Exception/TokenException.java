package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0506
 * @since 1.7
 */
@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Token might be " +
        "expired or malformed, please log in again.")
public class TokenException extends RuntimeException {
}

