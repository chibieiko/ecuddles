package com.evil.Service;

import com.evil.Entity.User;
import com.evil.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0328
 * @since 1.7
 */

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public SpringDataJpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws
            UsernameNotFoundException {
        User user = this.repository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), AuthorityUtils
                .createAuthorityList(user.getRole()));
    }
}
