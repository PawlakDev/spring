package com.example.studia;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class SignupControllerErrorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShortPasswordError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register/save")
                        .param("username", "testuser")
                        .param("password", "short") // Password is too short, should trigger validation error
                        .param("firstName", "Test")
                        .param("lastName", "User")
                        .param("birthYear", "1999"))
                .andExpect(status().isForbidden());
         //       .andExpect(content().string("Password must be at least X characters long")); // Replace X with the minimum password length constraint
    }
}
