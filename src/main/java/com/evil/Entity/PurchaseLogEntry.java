package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany
    private User user;

    @OneToMany
    private Product product;

    private Date bought;
}
