package com.example.studia.services;

import com.example.studia.models.UserEntity;
import com.example.studia.repositories.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserEntityRepository userEntityRepository;

    public void createUser(){
        UserEntity user = new UserEntity();
        user.setBirthYear(2000);
        user.setUsername("ble");
        user.setFirstName("ble");
        user.setLastName("ble");
        user.setRoles("ROLE_USER");
        user.setId(3l);
        user.setPassword(passwordEncoder.encode("1234"));
        userEntityRepository.save(user);
    }
}
