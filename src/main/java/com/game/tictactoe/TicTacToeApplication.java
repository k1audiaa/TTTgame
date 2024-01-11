package com.game.tictactoe;

import com.game.tictactoe.persistence.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TicTacToeApplication extends UserEntity {

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeApplication.class, args);
    }

    public void setId(long l) {
    }

    public void setBoard(String xoxoxoxox) {
    }

    public void setCurrentPlayer(String x) {
    }

    public long getId() {
        return 0;
    }

    public String getCurrentPlayer() {
        return null;
    }

    public List<String> getBoard() {
        return null;
    }
}