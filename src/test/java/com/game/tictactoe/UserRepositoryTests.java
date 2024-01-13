package com.game.tictactoe;

import com.game.tictactoe.persistence.UserEntity;
import com.game.tictactoe.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername_ExistingUsername_ReturnsUserEntity() {
        UserEntity userEntity = new UserEntity("testUser", 100, 1);
        userRepository.save(userEntity);

        UserEntity foundUser = userRepository.findByUsername("testUser");

        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getUsername());
    }

    @Test
    public void findByUsername_NonExistingUsername_ReturnsNull() {
        UserEntity foundUser = userRepository.findByUsername("nonExistingUser");

        assertNull(foundUser);
    }

    @Test
    public void findAllByUsername_NonExistingUsername_ReturnsEmptyList() {
        List<UserEntity> foundUsers = userRepository.findAllByUsername("nonExistingUser");

        assertTrue(foundUsers.isEmpty());
    }
}

