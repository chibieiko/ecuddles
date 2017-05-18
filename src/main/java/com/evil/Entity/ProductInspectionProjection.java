package com.evil.Entity;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inspect", types = { Product.class })
public interface ProductInspectionProjection {
    int getId();
    String getName();
    String getDescription();
    double getPrice();
    String getFabric();
    String getFilling();
    String getDesigner();
    double getHeight();
    double getWidth();
    double getLength();
    double getWeight();
    String getDisposeInstructions();
    int getStock();
    String getColor();
    String getCareInstructions();
    List<Picture> getPictures();
    List<Category> getCategories();
    List<Review> getReviews();
}