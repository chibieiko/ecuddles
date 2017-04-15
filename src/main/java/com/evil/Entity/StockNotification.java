package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by vili on 15/04/2017.
 */
@Entity
@Data
@NoArgsConstructor
public class StockNotification {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;
}
