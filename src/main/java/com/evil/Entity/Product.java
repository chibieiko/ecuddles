package com.evil.Entity;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0328
 * @since 1.7
 */

@Data
@Entity
public class Product {

    private @Id @GeneratedValue Long id;

    @Column(name = "name", nullable = false)
    private String name;

    /*
    private String description;
    private float price;
    private String fabric;
    private String filling;
    private String designer;
    private float height;
    private float width;
    private float length;
    private float weight;
    private String disposeInstruction;
    private int stock;
    private String color;
    */

    @OneToMany(cascade=CascadeType.ALL)
    private List<Picture> pictures;

    @ManyToMany(cascade=CascadeType.ALL)
    private List<Category> categories;

    private Product() {}

    public Product(String name) {
        this.name = name;
    }
}
