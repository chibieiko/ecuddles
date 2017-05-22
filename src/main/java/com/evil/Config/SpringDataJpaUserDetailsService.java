package com.evil.Config;

import com.evil.Entity.User;
import com.evil.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Implements user details service.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

    /**
     * User repository.
     */
    private final UserRepository repository;

    /**
     * Initializes user repository variable.
     * @param repository
     */
    @Autowired
    public SpringDataJpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Loads user details by email address.
     *
     * @param email                         Email
     * @return                              User details
     * @throws UsernameNotFoundException    Exception
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws
            UsernameNotFoundException {
        User user = this.repository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), AuthorityUtils
                .createAuthorityList(user.getRole()));
    }
}
