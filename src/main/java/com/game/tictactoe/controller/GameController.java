package com.game.tictactoe.controller;

import com.game.tictactoe.TicTacToeGame;
import com.game.tictactoe.service.UserService;
//import com.game.tictactoe.service.UserService;
import org.springframework.web.bind.annotation.RestController;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController{

    @Autowired
    UserService service;

    Logger logger = LoggerFactory.getLogger(GameController.class);

    @PostMapping("/things")
    public TicTacToeGame createThing(@RequestBody TicTacToeGame thing) {
        return service.save(thing);
    }

    @GetMapping("/things/{id}")
    public TicTacToeGame getThing(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long thingId = Long.parseLong(id);
        return service.get(thingId);
    }

    @GetMapping("/things")
    public List<TicTacToeGame> getAllThings() {
        return service.getAll();
    }

}

