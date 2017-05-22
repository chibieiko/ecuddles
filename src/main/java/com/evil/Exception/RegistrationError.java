package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Implements exception for when registration fails.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="User could not be registered. The username might be taken already.")
public class RegistrationError extends RuntimeException {
}
