package com.game.tictactoe;

import com.game.tictactoe.persistence.UserEntity;
import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    void testToString() {
       //Eingabedaten
        String username = "username";
        String points = "points";
        String password = "password";
        String level = "level";

        //"System under Test" aufsetzen
        UserEntity userEntity = new UserEntity(username, password, points, level);

        // Erwartetes Ergebnis
        String expected = "UserEntity{id=0, username='username', points='points', password='password', level='level'}";

        // Tatsächliches Ergebnis
        String actual = userEntity.toString();

        // Vergleich
        assert(expected.equals(actual));

    }
}
