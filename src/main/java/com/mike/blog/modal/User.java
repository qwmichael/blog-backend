package com.mike.blog.modal;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * This is the entity for user
 *
 * @author Michael Ng
 *
 */
@Entity
@Table(name = "Bloguser")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
