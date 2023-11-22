package com.eurder.users;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@UserDefinition
@Table(name = "users")
public class User extends PanacheEntity {

    @Username
    @NotBlank
    @Column(unique = true)
    public String email;
    @Password
    @NotBlank
    public String password;
    @Roles
    public String role;

    public static void add(String email, String password, String role) {
        User user = new User();
        user.email = email;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.persist();
    }

    public User() {

    }
}
