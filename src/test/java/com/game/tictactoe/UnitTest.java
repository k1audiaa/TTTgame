package com.game.tictactoe;

import com.game.tictactoe.persistence.UserEntity;
import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    void testToSTring() {
       //Eingabedaten
        String username = "username";
        String points = "points";
        String password = "password";

        //"System under Test" aufsetzen
        UserEntity userEntity = new UserEntity(username, password, points);

        // Erwartetes Ergebnis
String expected = "UserEntity{id=0, username='username', points='points', password='password'}";

        // Tatsächliches Ergebnis
        String actual = userEntity.toString();

        // Vergleich
        assert(expected.equals(actual));

    }
}
