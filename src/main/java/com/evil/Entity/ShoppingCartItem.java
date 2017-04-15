package com.evil.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by vili on 15/04/2017.
 */
@Entity
@Data
@NoArgsConstructor
public class ShoppingCartItem {
    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    private int quantity;

    @ManyToOne
    private Product product;
}
