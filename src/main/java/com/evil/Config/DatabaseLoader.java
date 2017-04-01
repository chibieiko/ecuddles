package com.evil.Config;

import com.evil.Entity.User;
import com.evil.Entity.Product;
import com.evil.Repository.UserRepository;
import com.evil.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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
public class DatabaseLoader implements CommandLineRunner {

    private final ProductRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public DatabaseLoader(ProductRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        try {
            this.userRepository.save(new User("admin@admin.com", "admin", "admin", "ADMIN"));
        } catch (Exception e) {
            System.out.println("User already exists.");
        }

        this.repository.save(new Product("Teddy"));
        this.repository.save(new Product("Bunny"));
        this.repository.save(new Product("Lion"));
    }
}
