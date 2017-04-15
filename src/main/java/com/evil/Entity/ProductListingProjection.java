package com.evil.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "list", types = { Product.class })
public interface ProductListingProjection {
    int getId();
    String getName();
    double getPrice();
    int getStock();
    @Value("#{target.getPictures().size() > 0 ? target.getPictures()[0] : null}")
    Picture getPicture();
}