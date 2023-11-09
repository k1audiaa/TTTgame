package com.game.tictactoe.service;

import com.game.tictactoe.TicTacToeGame;
import com.game.tictactoe.controller.TicTacToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    TicTacToeRepository repo;

    public TicTacToeGame save(TicTacToeGame thing) {
        return repo.save(thing);
    }

    public TicTacToeGame get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<TicTacToeGame> getAll() {
        Iterable<TicTacToeGame> iterator = repo.findAll();
        List<TicTacToeGame> things = new ArrayList<TicTacToeGame>();
        for (TicTacToeGame thing : iterator)  things.add(thing);
        return things;
    }

    public void delete(Long thingId) {
        repo.deleteById(thingId);

    }
}