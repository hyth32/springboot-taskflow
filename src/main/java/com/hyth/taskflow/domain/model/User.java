package com.hyth.taskflow.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class User {
    
    @EqualsAndHashCode.Include
    private final Long id;

    private final String username;
    private final String email;
    private final String password;
    
    public User withUsername(String username) {
        return new User(this.id, username, this.email, this.password);
    }

    public User withEmail(String email) {
        return new User(this.id, this.username, email, this.password);
    }

    public User withPassword(String password) {
        return new User(this.id, this.username, this.email, password);
    }
}
