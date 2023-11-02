package com.game.tictactoe.controller;

import com.game.tictactoe.TicTacToeGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicTacToeRepository extends CrudRepository<TicTacToeGame, Long> { }
