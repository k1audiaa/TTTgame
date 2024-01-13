package com.game.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.game.tictactoe.service.UserService;
import com.game.tictactoe.web.UserRestController;
import com.game.tictactoe.web.api.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserRestControllerTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserRestController userRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getUserById_UserExists_ReturnsUser() {
        long userId = 1L;
        User mockUser = new User(userId, "testUser", 100, 1);
        when(userService.findById(userId)).thenReturn(mockUser);

        ResponseEntity<User> response = userRestController.getUserById(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUser, response.getBody());
    }

    @Test
    public void getUserById_UserDoesNotExist_ReturnsNotFound() {
        long userId = 1L;
        when(userService.findById(userId)).thenReturn(null);

        ResponseEntity<User> response = userRestController.getUserById(userId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
}

