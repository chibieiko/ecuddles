package com.evil.Entity;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "list", types = { Product.class })
public interface ProductListingProjection {
    int getId();
    String getName();
    List<Picture> getPictures();
}