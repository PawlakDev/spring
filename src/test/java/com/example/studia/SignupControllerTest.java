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
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignupControllerTest {

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
    void testShowRegistrationForm() {
        // Given
        String expectedViewName = "register";

        // When
        String actualViewName = signupController.showRegistrationForm(model);

        // Then
        assertEquals(expectedViewName, actualViewName);
        verify(model).addAttribute(eq("user"), any(UserEntity.class));
    }

    @Test
    void testCustomLogin() {
        // Given
        String expectedViewName = "login";

        // When
        String actualViewName = signupController.customLogin();

        // Then
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    void testRegistration() {
        // Given
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("imie");
        userEntity.setLastName("nazwisko");
        userEntity.setUsername("randomusername");
        userEntity.setPassword("password123");
        // (String firstName, String lastName, String username, int birth, String password )

        // When
        String result = signupController.registration(userEntity, mock(BindingResult.class), model);

        // Then
        assertEquals("redirect:/register?success", result);
        verify(userService).createUser("imie", "nazwisko", "randomusername", 1999, "password123");
    }
}
