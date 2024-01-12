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
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGameByID(){

        TicTacToeApplication mockGame = new TicTacToeApplication();
        mockGame.setId(1L);
        mockGame.setBoard(Arrays.asList("X", "", "O", "", "X", "", "O", "", "").toString());
        mockGame.setCurrentPlayer("X");

        when(userRepository.findById(1L)).thenReturn((Optional.<UserEntity>of(mockGame)));

        TicTacToeApplication resultGame = userService.getGameById(1L);

        assertEquals(1L, resultGame.getId());
        assertEquals(Arrays.asList("X", "", "O", "", "X", "", "O", "", ""), resultGame.getBoard());
        assertEquals("X", resultGame.getCurrentPlayer());
    }
}
