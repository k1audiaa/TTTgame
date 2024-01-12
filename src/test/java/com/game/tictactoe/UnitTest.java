package com.game.tictactoe;

import com.game.tictactoe.persistence.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {

    @Test
    void testToString() {
        // Eingabedaten
        String username = "username";
        int points = 100; // Hier einen gültigen Punktwert einsetzen
        String password = "password";
        int level = 1; // Hier einen gültigen Level-Wert einsetzen

        // "System under Test" aufsetzen
        UserEntity userEntity = new UserEntity(username, password, points, level);

        // Erwartetes Ergebnis
        String expected = "UserEntity{id=0, username='username', points=100, password='password', level=1}";

        // Tatsächliches Ergebnis
        String actual = userEntity.toString();

        // Vergleich
        assertEquals(expected, actual);
    }
}

