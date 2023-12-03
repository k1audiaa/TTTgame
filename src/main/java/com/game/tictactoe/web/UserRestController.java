package com.game.tictactoe.web;

import com.game.tictactoe.service.UserService;
import com.game.tictactoe.web.api.User;
import com.game.tictactoe.web.api.UserManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers() {
        var users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        var user = userService.findById(id);
        return user != null? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping("/api/users")
    public ResponseEntity<Void> createUser(@RequestBody UserManipulationRequest request) throws URISyntaxException {
        var user = userService.create(request);
        URI uri = new URI("/api/users/" + user.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserManipulationRequest request) {
        var user = userService.update(id, request);
        return user != null? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean succesful = userService.deleteById(id);
        return succesful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
