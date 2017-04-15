package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0415
 * @since 1.7
 */

@Data
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @ManyToOne(targetEntity = Product.class)
    private Product product;

    /*
    private String body;

    private int stars;
    */

   /* @OneToMany(cascade= CascadeType.ALL)
    private User user;*/
}
