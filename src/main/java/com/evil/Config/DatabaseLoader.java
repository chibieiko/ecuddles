package com.evil.Config;

import com.evil.Entity.Admin;
import com.evil.Entity.Category;
import com.evil.Entity.Picture;
import com.evil.Entity.Product;
import com.evil.Repository.AdminRepository;
import com.evil.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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
    private final AdminRepository adminRepository;

    @Autowired
    public DatabaseLoader(ProductRepository repository, AdminRepository adminRepository) {
        this.repository = repository;
        this.adminRepository = adminRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        try {
            this.adminRepository.save(new Admin("admin", "admin", "ADMIN"));
        } catch (Exception e) {
            System.out.println("Admin already exists.");
        }

        this.repository.save(new Product("Teddy"));
        this.repository.save(new Product("Bunny"));
        this.repository.save(new Product("Lion"));
    }
}
