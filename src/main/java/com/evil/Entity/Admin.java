package com.evil.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Admin {

    public static final PasswordEncoder PASSWORD_ENCODER = new
            BCryptPasswordEncoder();

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @JsonIgnore
    private String password;

    private String role;

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public Admin() {
    }

    public Admin(String name, String password, String role) {
        this.name = name;
        this.setPassword(password);
        this.role = role;
    }
}
