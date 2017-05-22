package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Implements data class for purchase log entry entity.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Data
@Entity
@NoArgsConstructor
public class PurchaseLogEntry {

    /**
     * Id of the entry.
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * User who bought the item.
     */
    @ManyToOne
    private User user;

    /**
     * Product that was bought.
     */
    @ManyToOne
    private Product product;

    /**
     * Quantity of the product.
     */
    private int quantity;

    /**
     * Name of the buyer.
     */
    private String name;

    /**
     * Address of the buyer.
     */
    private String address;

    /**
     * Postal code of the buyer.
     */
    private String postalCode;

    /**
     * City of the buyer.
     */
    private String city;

    /**
     * Phone number of the buyer.
     */
    private String phone;

    /**
     * Date the item was bought.
     */
    private Date bought;
}
