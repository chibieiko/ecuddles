package com.evil.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Implements filter for login using JWT.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * Initializes filter.
     *
     * @param url           URL
     * @param authManager   Authentication manager
     */
    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    /**
     * Attempts to authenticate request.
     *
     * @param req                       Request
     * @param res                       Response
     * @return                          Authentication
     * @throws AuthenticationException  Exception
     * @throws IOException              Exception
     * @throws ServletException         Exception
     */
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {

        System.out.println("ATTEMPT AUTHENTICATION");

        AccountCredentials creds = new ObjectMapper()
                .readValue(req.getInputStream(), AccountCredentials.class);

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        creds.getEmail(),
                        creds.getPassword(),
                        Collections.emptyList()
                )
        );
    }

    /**
     * Adds authentication to request when login succeeds.
     *
     * @param req                   Request
     * @param res                   Response
     * @param chain                 Filter chain
     * @param auth                  Authentication
     * @throws IOException          Exception
     * @throws ServletException     Exception
     */
    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        TokenAuthenticationService
                .addAuthentication(res, auth.getName());
    }
}