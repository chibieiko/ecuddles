package com.evil.Config;

import com.evil.Entity.User;
import com.evil.Service.SpringDataJpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0328
 * @since 1.7
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpringDataJpaUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws
            Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder
                (User.PASSWORD_ENCODER);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/products/**").hasRole
                ("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/products/**").hasRole
                ("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/products/**").hasRole
                ("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/api/products/**").hasRole
                ("ADMIN")
                .antMatchers("/api/cart/**").authenticated()
                .and()
            .formLogin()
                .usernameParameter("email")
                .loginProcessingUrl("/api/login")
                .defaultSuccessUrl("/api", true)
                .permitAll()
                .and()
            .csrf().disable()
            .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/api");
    }
 }
