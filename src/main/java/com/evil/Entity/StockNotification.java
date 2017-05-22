package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Implements data class for stock notification entity.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Entity
@Data
@NoArgsConstructor
public class StockNotification {

    /**
     * Id of the stock notification.
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * Product to subscribe for.
     */
    @ManyToOne
    private Product product;

    /**
     * User to notify.
     */
    @ManyToOne
    private User user;
}
