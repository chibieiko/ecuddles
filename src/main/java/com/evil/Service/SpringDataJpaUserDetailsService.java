package com.evil.Service;

import com.evil.Entity.Admin;
import com.evil.Entity.Product;
import com.evil.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
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

    private final AdminRepository repository;

    @Autowired
    public SpringDataJpaUserDetailsService(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws
            UsernameNotFoundException {
        Admin admin = this.repository.findByName(name);
        return new User(admin.getName(), admin.getPassword(), AuthorityUtils
                .createAuthorityList(admin.getRole()));
    }
}
