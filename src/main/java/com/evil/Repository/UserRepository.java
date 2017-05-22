package com.evil.Repository;


import com.evil.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * Implements repository for users.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Saves user.
     *
     * @param user User to save
     * @return     Saved user
     */
    User save(User user);

    /**
     * Finds user by email.
     *
     * @param email Email
     * @return      User
     */
    User findByEmail(String email);
}
