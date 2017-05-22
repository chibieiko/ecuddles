package com.evil.Config;

import com.evil.Entity.Category;
import com.evil.Entity.MockData;
import com.evil.Entity.Product;
import com.evil.Entity.User;
import com.evil.Repository.CategoryRepository;
import com.evil.Repository.ProductRepository;
import com.evil.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Generates dummy data for database on startup.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    /**
     * Product repository.
     */
    private final ProductRepository repository;

    /**
     * User repository.
     */
    private final UserRepository userRepository;

    /**
     * Category repository.
     */
    private final CategoryRepository categoryRepository;

    /**
     * Initializes repository fields.
     *
     * @param repository            Product repository
     * @param userRepository        User repository
     * @param categoryRepository    Category repository
     */
    @Autowired
    public DatabaseLoader(ProductRepository repository, UserRepository
            userRepository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    /**
     * Runs dummy data generation to database.
     *
     * @param strings       Strings
     * @throws Exception    Thrown when exception occurs
     */
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
            String[] categorynames = {"Soft", "Hard", "Digimon", "Pokémon",
            "Animal", "Teddy bear", "Bunny", "Fox"};

            ArrayList<Category> categories = new ArrayList<Category>(){{
                for (String categoryname : categorynames) {
                    add(MockData.getCategory(categoryname));
                }
            }};

            categoryRepository.save(categories);

            // Create and persist Products.
            for (int i = 0; i < 200; i++) {
                Product product = MockData.getProduct(categories);
                repository.save(product);
            }
        }
    }
}
