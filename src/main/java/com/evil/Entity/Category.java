package com.evil.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @JsonBackReference
    @ManyToMany(targetEntity = Product.class, mappedBy = "categories", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
