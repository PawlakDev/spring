package com.example.studia.controllers;

import com.example.studia.AuthRequest;
import com.example.studia.services.JwtService;
import com.example.studia.models.UserEntity;
import com.example.studia.repositories.UserEntityRepository;
import com.example.studia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserEntityRepository entityRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService createUser;

    @GetMapping("/hello")
    public String welcome() {
        return "This endpoint is not secured";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserEntity> getAllTheProducts() {
        return entityRepository.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public UserEntity getProductById(@PathVariable long id) {
        return entityRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            if (authentication.isAuthenticated()) {
                System.out.println("authenticated");
                return jwtService.generateToken(authRequest.getUsername());
            } else {
                throw new UsernameNotFoundException("invalid user request !");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
