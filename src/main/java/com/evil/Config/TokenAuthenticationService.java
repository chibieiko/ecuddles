package com.evil.Config;

import com.evil.Entity.User;
import com.evil.Exception.TokenException;
import com.evil.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Implements authentication service for JWT tokens.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Component
public class TokenAuthenticationService {

    /**
     * User repository.
     */
    private static UserRepository userRepository;

    /**
     * Initializes user repository variable.
     *
     * @param repository    User repository
     */
    @Autowired
    public TokenAuthenticationService(UserRepository repository) {
        TokenAuthenticationService.userRepository = repository;
    }

    /**
     * Expiration time of the token.
     */
    static final long EXPIRATIONTIME = 864_000_000; // 10 days

    /**
     * Secret of the token.
     */
    static final String SECRET = "J3247Fb4389rhf377JEW01";

    /**
     * Header of the token.
     */
    static final String HEADER_STRING = "Authorization";

    /**
     * Adds authentication to the response based on the email supplied.
     *
     * @param res       Response
     * @param email     Email of the authenticated user
     */
    static void addAuthentication(HttpServletResponse res, String email) {
        String JWT = Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, JWT);
        res.addHeader("Content-Type", "application/json");

        try {
            User user = userRepository.findByEmail(email);

            String responseBody = "{" +
                    "\"token\": \"" + JWT + "\"," +
                    "\"user\": {" +
                    "\"email\": \"" + user.getEmail() + "\"," +
                    "\"name\": \"" + user.getName() + "\"," +
                    "\"role\": \"" + user.getRole() + "\"," +
                    "\"id\": \"" + user.getId() + "\"" +
                    "}" +
                    "}";

            res.getOutputStream().print(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets authentication of a request.
     *
     * @param request   Request
     * @return          Authentication of the request
     */
    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {

            String email = "";

            try {
                email = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
            } catch (Exception e) {
                throw new TokenException();
            }

            User user = userRepository.findByEmail(email);

            return email != null && user != null ?
                    new UsernamePasswordAuthenticationToken(email, user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole())) :
                    null;
        }

        return null;
    }
}