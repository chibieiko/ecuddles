package com.evil.Repository;


import com.evil.Entity.Admin;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

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
public interface AdminRepository extends Repository<Admin, Long> {

    Admin save(Admin admin);

    Admin findByName(String name);
}
