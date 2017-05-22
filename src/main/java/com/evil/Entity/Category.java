package com.evil.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Implements data class for category entity.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Entity
@Data
@NoArgsConstructor
public class Category {

    /**
     * Id of the category.
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * Name of the category.
     */
    private String name;

    /**
     * Products of the category.
     */
    @JsonBackReference
    @ManyToMany(targetEntity = Product.class, mappedBy = "categories", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
