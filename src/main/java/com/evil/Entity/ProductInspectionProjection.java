package com.evil.Entity;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inspect", types = { Product.class })
public interface ProductInspectionProjection {
    int getId();
    String getName();
    List<Picture> getPictures();
    List<Category> getCategories();
}