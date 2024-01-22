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


    public void createUser(String firstName, String lastName, String password, int birth){
        UserEntity user = new UserEntity();
        user.setBirthYear(birth);
        user.setRoles("ROLE_USER");
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));
        userEntityRepository.save(user);
    }
}
