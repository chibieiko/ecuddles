package com.evil.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0328
 * @since 1.7
 */

@Data
@ToString(exclude = "password")
@Entity
public class User {
    public static final PasswordEncoder PASSWORD_ENCODER = new
            BCryptPasswordEncoder();

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "role", nullable = false)
    @JsonIgnore
    private String role;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> shoppingCartProducts = new ArrayList<>();

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public User() {
    }

    public User(String email, String name, String password, String role) {
        this.email = email;
        this.name = name;
        this.setPassword(password);
        this.role = role;
    }
}
