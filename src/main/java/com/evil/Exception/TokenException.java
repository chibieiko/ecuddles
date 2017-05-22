package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Implements exception for when token is malformed or expired.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Token might be " +
        "expired or malformed, please log in again.")
public class TokenException extends RuntimeException {
}

