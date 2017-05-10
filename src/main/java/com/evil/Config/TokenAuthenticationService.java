package com.evil.Config;

import com.evil.Entity.User;
import com.evil.Exception.TokenException;
import com.evil.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security
        .authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class TokenAuthenticationService {
    private static UserRepository userRepository;

    @Autowired
    public TokenAuthenticationService(UserRepository repository) {
        TokenAuthenticationService.userRepository = repository;
    }

    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "J3247Fb4389rhf377JEW01";
    static final String HEADER_STRING = "Authorization";

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