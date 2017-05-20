package com.evil.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

/**
 * Created by vili on 15/04/2017.
 */
@Projection(name = "list", types = { PurchaseLogEntry.class })
public interface LogProjection {
    int getQuantity();

    Date getBought();

    @Value("#{target.getProduct().getId()}")
    int getProductId();

    @Value("#{target.getProduct().getName()}")
    String getProductName();

    @Value("#{target.getUser().getId()}")
    int getUserId();

    @Value("#{target.getUser().getEmail()}")
    String getUserEmail();

    String getName();

    String getAddress();

    String getCity();

    String getPostalCode();

    String getPhone();
}
