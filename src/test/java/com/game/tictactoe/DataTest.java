package com.game.tictactoe;
import com.game.tictactoe.persistence.UserEntity;
import com.game.tictactoe.persistence.UserRepository;
import com.game.tictactoe.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DataTest {
    //Annahme : Datenbankenzugriff funktioniert
    @Mock
    private UserRepository userRepository;
    // Die zu testende Klasse wird mit den Mocks injiziert
    @InjectMocks
    private UserService userService;
    //Beispietest der überprüft ob die richtige Daten aus der Datenbank geholt werden
    @Test
    public void testGameByID(){
        // Mock-Daten für die Datenbankantwort
        TicTacToeApplication mockGame = new TicTacToeApplication();
        mockGame.setId(1L);
        mockGame.setBoard(Arrays.asList("X", "", "O", "", "X", "", "O", "", "").toString());
        mockGame.setCurrentPlayer("X");

        // Konfiguration des Mocks: Wenn die Methode findById(1L) aufgerufen wird, gibt sie das Mock-Spiel zurück
        when(userRepository.findById(1L)).thenReturn((Optional.<UserEntity>of(mockGame)));

        // Test: Überprüfe, ob die Methode getGameById() des Services die erwarteten Daten zurückgibt
        TicTacToeApplication resultGame = userService.getGameById(1L);

        // Assertions: Überprüfe, ob die zurückgegebenen Daten den erwarteten Daten entsprechen
        assertEquals(1L, resultGame.getId());
        assertEquals(Arrays.asList("X", "", "O", "", "X", "", "O", "", ""), resultGame.getBoard());
        assertEquals("X", resultGame.getCurrentPlayer());
    }
}
