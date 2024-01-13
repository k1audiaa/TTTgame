package com.game.tictactoe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.game.tictactoe.persistence.UserEntity;
import com.game.tictactoe.persistence.UserRepository;
import com.game.tictactoe.service.UserService;
import com.game.tictactoe.web.api.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAll_ReturnsListOfUsers() {
        List<UserEntity> mockUserEntities = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(mockUserEntities);

        List<User> result = userService.findAll();

        assertEquals(mockUserEntities.size(), result.size());
    }

    @Test
    public void calculateLevel_PointsBelowThreshold_ReturnsZero() {
        int points = 50;

        int result = userService.calculateLevel(points);

        assertEquals(0, result);
    }

    @Test
    public void calculateLevel_PointsWithinThreshold_ReturnsCorrectLevel() {
        int points = 150;

        int result = userService.calculateLevel(points);

        assertEquals(1, result);
    }

    @Test
    public void findById_ExistingUserId_ReturnsUser() {
        UserEntity userEntity = new UserEntity("testUser", 100, 1);
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        User foundUser = userService.findById(1L);

        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUsername());
    }

    @Test
    public void findById_NonExistingUserId_ReturnsNull() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        User foundUser = userService.findById(1L);

        assertNull(foundUser);
    }
}

