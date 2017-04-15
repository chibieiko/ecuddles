package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vili on 15/04/2017.
 */
@Data
@Entity
@NoArgsConstructor
public class PurchaseLogEntry {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private int quantity;

    private Date bought;
}
