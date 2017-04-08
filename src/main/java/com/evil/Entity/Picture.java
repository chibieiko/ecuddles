package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0331
 * @since 1.7
 */

@Data
@Entity
@NoArgsConstructor
public class Picture {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String url;

    private String description;

    @Column(nullable = false)
    private boolean primary;
}
