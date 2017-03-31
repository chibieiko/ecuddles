package com.evil.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0331
 * @since 1.7
 */

@Data
@Entity
public class Picture {

    @Id
    @GeneratedValue
    private long id;

    private String url;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Picture() {
    }

    public Picture(String url, String description, Product product) {
        this.url = url;
        this.description = description;
        this.product = product;
    }
}
