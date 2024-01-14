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

}