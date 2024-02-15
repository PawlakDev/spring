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


    public void createUser(String firstName, String lastName, String username, int birth, String password ){
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setBirthYear(birth);
        user.setRoles("ROLE_ADMIN");
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));
        userEntityRepository.save(user);
    }

    public Long findUserIdByUsername(String username){
        return userEntityRepository.findByUsername(username).get().getId();
    }

}
