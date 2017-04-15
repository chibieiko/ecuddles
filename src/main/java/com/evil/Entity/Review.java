package com.evil.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
