package com.game.tictactoe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLogin() throws Exception {
        String username = "testUser";
        String password = "testPassword";

        // Test: Führe eine POST-Anfrage zum Endpunkt "/login" mit Benutzername und Passwort durch
        mockMvc.perform(post("/login")
                        .content("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}")
                        .contentType(MediaType.APPLICATION_JSON)) // Setze den Content-Type explizit auf JSON
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.username").value(username))
                .andExpect(jsonPath("$.password").value(password));
    }
}
