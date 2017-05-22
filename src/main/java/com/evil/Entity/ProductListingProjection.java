package com.evil.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Implements projection for listing of products.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Projection(name = "list", types = { Product.class })
public interface ProductListingProjection {

    /**
     * Gets id of the product.
     *
     * @return Id of the product
     */
    int getId();

    /**
     * Gets name of the product.
     *
     * @return Name of the product
     */
    String getName();

    /**
     * Gets price of the product.
     *
     * @return Price of the product
     */
    double getPrice();

    /**
     * Gets stock of the product.
     *
     * @return Stock of the product
     */
    int getStock();

    /**
     * Gets picture of the product.
     *
     * @return Picture of the product
     */
    @Value("#{target.getPictures().size() > 0 ? target.getPictures()[0] : null}")
    Picture getPicture();
}