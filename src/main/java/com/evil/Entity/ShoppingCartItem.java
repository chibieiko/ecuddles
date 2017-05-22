package com.evil.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Implements data class for shopping cart item entity.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Entity
@Data
@NoArgsConstructor
public class ShoppingCartItem {

    /**
     * Id of the shopping cart item.
     */
    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    /**
     * Quantity of the product in cart.
     */
    private int quantity;

    /**
     * Product in cart.
     */
    @ManyToOne
    private Product product;
}
