package com.game.tictactoe;

import com.game.tictactoe.persistence.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {

    @Test
    void testToString() {
        String username = "username";
        int points = 100;
        String password = "password";
        int level = 1;

        UserEntity userEntity = new UserEntity(username, password, points, level);

        String expected = "UserEntity{id=0, username='username', points=100, password='password', level=1}";

        String actual = userEntity.toString();

        assertEquals(expected, actual);
    }
}

