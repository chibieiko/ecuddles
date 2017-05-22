package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Implements data class for product entity.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Data
@Entity
@NoArgsConstructor
public class Product {

    /**
     * Id of the product.
     */
    private @Id @GeneratedValue int id;

    /**
     * Date of addition.
     */
    @Column(nullable = false)
    private Date date = new Date();

    /**
     * Name of the product.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Description of the product.
     */
    @Column(nullable = false, length = 10000)
    private String description;

    /**
     * Price of the product.
     */
    @Column(nullable = false, precision = 2)
    private double price;

    /**
     * Fabric of the product.
     */
    @Column(nullable = false, length = 100)
    private String fabric;

    /**
     * Filling of the product.
     */
    @Column(nullable = false, length = 100)
    private String filling;

    /**
     * Designer of the product.
     */
    @Column(length = 50)
    private String designer;

    /**
     * Height of the product.
     */
    @Column(nullable = false, precision = 2)
    private double height;

    /**
     * Width of the product.
     */
    @Column(nullable = false, precision = 2)
    private double width;

    /**
     * Length of the product.
     */
    @Column(nullable = false, precision = 2)
    private double length;

    /**
     * Weight of the product.
     */
    @Column(nullable = false, precision = 2)
    private double weight;

    /**
     * Dispose instructions for the product.
     */
    @Column(nullable = false)
    private String disposeInstructions;

    /**
     * Stock of the product.
     */
    @Column(nullable = false)
    private int stock;

    /**
     * Color of the product.
     */
    @Column(nullable = false, length = 50)
    private String color;

    /**
     * Care instructions for the product.
     */
    @Column(nullable = false)
    private String careInstructions;

    /**
     * Pictures of the product.
     */
    @OneToMany(cascade=CascadeType.ALL)
    private List<Picture> pictures;

    /**
     * Categories of the product.
     */
    @ManyToMany(cascade=CascadeType.MERGE)
    private List<Category> categories;

    /**
     * Reviews of the product.
     */
    @OneToMany
    private List<Review> reviews;
}
