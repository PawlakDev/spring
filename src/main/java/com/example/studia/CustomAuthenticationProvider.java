package com.example.studia;

import com.example.studia.models.User;
import com.example.studia.repositories.UserRepository;
import com.example.studia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static com.example.studia.ConfigSecurity.passwordEncoder;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    UserRepository userRepository ;
    public CustomAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        UserService userService = new UserService(userRepository);

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

            User user = (User) userService.loadUserByUsername(name);


        return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());


//        if (user != null && passwordEncoder().matches(password, user.getPassword())) {
//
//        } else {
//
//        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}