package com.evil.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vili on 01/04/2017.
 */
@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="User could not be registered. The username might be taken already.")
public class RegistrationError extends RuntimeException {
}
