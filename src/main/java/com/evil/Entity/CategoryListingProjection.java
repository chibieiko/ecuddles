package com.evil.Entity;

import org.springframework.data.rest.core.config.Projection;

/**
 * Implements projection for categories.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Projection(name = "list", types = { Category.class })
public interface CategoryListingProjection {

    /**
     * Gets id of the category.
     *
     * @return  Id of the category
     */
    int getId();

    /**
     * Gets name of the category.
     *
     * @return  Name of the category
     */
    String getName();
}
