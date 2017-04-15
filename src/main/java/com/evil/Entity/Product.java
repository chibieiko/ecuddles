package com.evil.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * TODO Short Description
 * <p>
 * TODO caption and @since
 *
 * @author Erika Sankari
 * @version 2017.0328
 * @since 1.7
 */

@Data
@Entity
@NoArgsConstructor
public class Product {
    private @Id @GeneratedValue int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 10000)
    private String description;

    @Column(nullable = false, precision = 2)
    private double price;

    @Column(nullable = false, length = 100)
    private String fabric;

    @Column(nullable = false, length = 100)
    private String filling;

    @Column(length = 50)
    private String designer;

    @Column(nullable = false, precision = 2)
    private double height;

    @Column(nullable = false, precision = 2)
    private double width;

    @Column(nullable = false, precision = 2)
    private double length;

    @Column(nullable = false, precision = 2)
    private double weight;

    @Column(nullable = false)
    private String disposeInstructions;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false, length = 50)
    private String color;

    @Column(nullable = false)
    private String careInstructions;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Picture> pictures;

    @ManyToMany(cascade=CascadeType.MERGE)
    private List<Category> categories;

    @OneToMany
    private List<Review> reviews;
}
