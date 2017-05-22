package com.evil.Config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.core.Authentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Implements filter for JWT authentication.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Service
public class JWTAuthenticationFilter extends GenericFilterBean {

    /**
     * Filters incoming requests to find out if they are authenticated.
     *
     * @param request           Request
     * @param response          Response
     * @param filterChain       Filter chain
     * @throws IOException      Exception
     * @throws ServletException Exception
     */
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService
                .getAuthentication((HttpServletRequest) request);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}