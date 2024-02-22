package com.example.studia;

import com.example.studia.controllers.SignupController;
import com.example.studia.models.UserEntity;
import com.example.studia.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignupControllerErrorTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private SignupController signupController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testRegistrationUsernameAlreadyExists() {
        // Given
        UserEntity user = new UserEntity();
        user.setUsername("username");
        doThrow(new RuntimeException("User already exists")).when(userService).createUser(anyString(), anyString(), anyString(), anyInt(), anyString());

        // When
        // Perform the action that should trigger the exception, which is creating a user with already existing username



        // Then
        // Add assertions or further verification as needed
    }
}