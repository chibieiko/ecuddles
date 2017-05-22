package com.evil.Config;

import lombok.Data;

/**
 * Implements data class for account credentials.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Data
public class AccountCredentials {
    private String email;
    private String password;
}