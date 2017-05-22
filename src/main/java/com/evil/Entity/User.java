package com.evil.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements data class for user entity.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Data
@NoArgsConstructor
@ToString(exclude = "password")
@Entity
public class User {

    /**
     * Password encoder.
     */
    public static final PasswordEncoder PASSWORD_ENCODER = new
            BCryptPasswordEncoder();

    /**
     * Id of the user.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Email of the user.
     */
    @Column(name = "email", nullable = false, unique = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    /**
     * Name of the user.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Password of the user.
     */
    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * Role of the user.
     */
    @Column(name = "role", nullable = false)
    @JsonIgnore
    private String role;

    /**
     * Shopping cart of the user.
     */
    @JsonIgnore
    @OneToMany
    private List<ShoppingCartItem> shoppingCartProducts;

    /**
     * Sets password for the user.
     *
     * @param password Password for the user
     */
    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    /**
     * Initializes user with given parameters.
     *
     * @param email     Email for the user
     * @param name      Name for the user
     * @param password  Password for the user
     * @param role      Role for the user
     */
    public User(String email, String name, String password, String role) {
        this.email = email;
        this.name = name;
        this.setPassword(password);
        this.role = role;
    }
}
