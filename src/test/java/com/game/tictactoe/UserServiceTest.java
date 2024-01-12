package com.game.tictactoe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.tictactoe.service.UserService;
import com.game.tictactoe.web.api.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserService.class)
public class UserServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetRoute() throws Exception {

        User user = new User(1,"username", "password", 1, 1);
        user.setId(1);
        when(userService.getUser()).thenReturn(user);
        String expected = "{\"id\":1,\"username\":\"username\",\"password\":\"password\",\"points\":1,\"level\":1}";

        this.mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }
}


