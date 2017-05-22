package com.evil.Entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

/**
 * Implements projection for logs.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Projection(name = "list", types = { PurchaseLogEntry.class })
public interface LogProjection {

    /**
     * Gets if of the log entry.
     *
     * @return Id of the log entry
     */
    long getId();

    /**
     * Gets quantity of the product bought.
     *
     * @return  Quantity of the product
     */
    int getQuantity();

    /**
     * Gets date of the purchase.
     *
     * @return Date of the purchase
     */
    Date getBought();

    /**
     * Gets id of the product bought.
     *
     * @return Purchased product id
     */
    @Value("#{target.getProduct().getId()}")
    int getProductId();

    /**
     * Gets name of the product bought.
     *
     * @return Purchased product name
     */
    @Value("#{target.getProduct().getName()}")
    String getProductName();

    /**
     * Gets id of the user who purchased the product.
     *
     * @return Buyer id
     */
    @Value("#{target.getUser().getId()}")
    int getUserId();

    /**
     * Gets email of the user who purchased the product.
     *
     * @return Buyer email
     */
    @Value("#{target.getUser().getEmail()}")
    String getUserEmail();

    /**
     * Gets name of the buyer.
     *
     * @return Name of the buyer
     */
    String getName();

    /**
     * Gets address of the buyer.
     *
     * @return Address of the buyer
     */
    String getAddress();

    /**
     * Gets city of the buyer.
     *
     * @return City of the buyer
     */
    String getCity();

    /**
     * Gets postal code of the buyer.
     *
     * @return Postal code of the buyer
     */
    String getPostalCode();

    /**
     * Gets phone number of the buyer.
     *
     * @return Phone number of the buyer
     */
    String getPhone();
}
