package com.evil.Entity;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by vili on 11/04/2017.
 */

@Projection(name = "list", types = { Category.class })
public interface CategoryListingProjection {
    int getId();
    String getName();
}
