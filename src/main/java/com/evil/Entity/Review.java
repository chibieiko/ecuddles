package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Implements data class for review entity.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Data
@NoArgsConstructor
@Entity
public class Review {

    /**
     * Id of the review.
     */
    @Id
    @GeneratedValue
    private long id;

    /**
     * Title of the review.
     */
    private String title;

    /**
     * User that wrote the review.
     */
    @ManyToOne
    private User user;

    /**
     * Body of the review.
     */
    private String body;

    /**
     * Stars given by the user.
     */
    private int stars;

    /**
     * Date of the review.
     */
    private Date date = new Date();
}
