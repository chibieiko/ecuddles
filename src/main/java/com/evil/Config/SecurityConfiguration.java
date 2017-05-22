package com.evil.Config;

import com.evil.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Implements security configuration for the app.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * User details service.
     */
    @Autowired
    private SpringDataJpaUserDetailsService userDetailsService;

    /**
     * Configures authentication manager.
     *
     * @param auth          Authentication manager builder
     * @throws Exception    Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws
            Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder
                (User.PASSWORD_ENCODER);
    }

    /**
     * Configures Http Security of the app.
     *
     * @param http          HttpSecurity
     * @throws Exception    Exception
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and().authorizeRequests()
                .mvcMatchers("/*").permitAll()
                .mvcMatchers("/assets/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/api/products/**").permitAll()
                .mvcMatchers(HttpMethod.GET, "/api/categories/**").permitAll()
                .mvcMatchers(HttpMethod.POST, "/api/login").permitAll()
                .mvcMatchers(HttpMethod.POST, "/api/register").permitAll()
                .mvcMatchers("/api/products/*/reviews").authenticated()
                .mvcMatchers("/api/cart/**").authenticated()
                .mvcMatchers("/api/notifications/**").authenticated()
                .anyRequest().hasAuthority("ADMIN")
                .and()
                // We filter the api/login requests
                .addFilterAfter(new JWTLoginFilter("/api/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .logout().disable();
    }

    /**
     * Configures CORS headers for all requests.
     * @return  CORS configuration source
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
 }
