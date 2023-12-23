package com.example.studia.models;

import jakarta.persistence.*;

import java.sql.ConnectionBuilder;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int birthYear;

//    public static ConnectionBuilder withUsername(String user1) {
//    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // logika przypisywania ról użytkownikowi
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
