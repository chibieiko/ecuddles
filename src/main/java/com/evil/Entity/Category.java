package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
@Entity
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    @Column(length = 4)
    private int id;

    private String name;

    @ManyToMany(targetEntity = Product.class, mappedBy = "categories")
    private List<Product> products;
}
