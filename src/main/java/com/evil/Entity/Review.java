package com.evil.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0415
 * @since 1.7
 */

@Data
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @ManyToOne
    private User user;

    private String body;

    private int stars;

    private Date date = new Date();
}
