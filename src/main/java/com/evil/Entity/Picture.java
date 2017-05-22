package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Implements data class for picture entity.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Data
@Entity
@NoArgsConstructor
public class Picture {

    /**
     * Id of the picture.
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * Url of the picture.
     */
    @Column(nullable = false)
    private String url;

    /**
     * Caption of the picture.
     */
    private String caption;
}