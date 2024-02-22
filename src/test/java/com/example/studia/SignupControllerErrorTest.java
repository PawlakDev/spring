package com.example.studia;

import com.example.studia.controllers.SignupController;
import com.example.studia.models.UserEntity;
import com.example.studia.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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


    // Nie działa ten test :(
    @Test
    void testRegistrationUsernameAlreadyExists() {
        // Given
        UserEntity user = new UserEntity();
        user.setUsername("username");
        user.setPassword("password");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setBirthYear(1990);

        // Mock the behavior of userService.createUser() to throw an exception when called with the specified username
        Mockito.doThrow(new RuntimeException("User already exists")).when(userService).createUser(eq(user.getUsername()), anyString(), anyString(), anyInt(), anyString());

        // When
        BindingResult bindingResult = new BeanPropertyBindingResult(user, "user");
        String actualViewName = signupController.registration(user, bindingResult, model);

        // Then
        assertTrue(bindingResult.hasErrors());
        assertEquals("register", actualViewName);
        assertTrue(bindingResult.getFieldError("username").getDefaultMessage().contains("User already exists"));
    }


}