package com.evil.Config;

import com.evil.Entity.*;
import com.evil.Repository.CategoryRepository;
import com.evil.Repository.UserRepository;
import com.evil.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * TODO Short Description
 * <p>
 * TODO caption and @since
 *
 * @author Erika Sankari
 * @version 2017.0328
 * @since 1.7
 */

// Creates dummydata when server is launched.

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ProductRepository repository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public DatabaseLoader(ProductRepository repository, UserRepository
            userRepository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        boolean generateMockdata = true;

        try {
            this.userRepository.save(new User("admin@admin.com", "admin", "admin", "ADMIN"));
        } catch (Exception e) {
            System.out.println("User already exists.");
            generateMockdata = false;
        }

        if (generateMockdata) {
            // Create and persist categories.
            String[] categorynames = {"Pehmeä", "Kova", "Digimon", "Pokémon",
            "Eläin", "Nalle", "Pupu", "Kettu"};

            ArrayList<Category> categories = new ArrayList<Category>(){{
                for (String categoryname : categorynames) {
                    add(MockData.getCategory(categoryname));
                }
            }};

            categoryRepository.save(categories);

            // Create and persist Products.
            for (int i = 0; i < 10; i++) {
                Product product = MockData.getProduct(categories);
                repository.save(product);
            }
        }
    }
}
