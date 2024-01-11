package com.game.tictactoe;

import com.game.tictactoe.service.UserService;
import com.game.tictactoe.web.api.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.reflect.Array.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrlTemplate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserService.class)
        public class UserServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetRoute() throws Exception {
       //Test Daten und Service Mock
        User user = new User(1,"username", "password", "points", "level");
        user.setId(1);
        when(userService.getUser()).thenReturn(user);
       //Erwartetes Ergebnis
        String expected = "{\"id\":1,\"username\":\"username\",\"password\":\"password\",\"points\":\"points\", \"level\":\"level\"}";
        //Aufruf und Vergleich
        this.mockMvc.perform(get("user"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expected));
    }
}
}
