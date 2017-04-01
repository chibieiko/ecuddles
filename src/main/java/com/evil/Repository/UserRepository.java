package com.evil.Repository;


import com.evil.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0328
 * @since 1.7
 */

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    User findByEmail(String email);
}
