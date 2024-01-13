package com.game.tictactoe.web;

import com.game.tictactoe.persistence.UserEntity;
import com.game.tictactoe.service.UserService;
import com.game.tictactoe.web.api.User;
import com.game.tictactoe.web.api.UserManipulationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/api/users/exists")
    public ResponseEntity<Map<String, Object>> doesUserExist(@RequestParam String username) {
        try {
            Map<String, Object> response = new HashMap<>();

            boolean userExists = userService.doesUserExistByUsername(username);

            response.put("exists", userExists);

            if (userExists) {
                UserEntity user = userService.findByUsername(username);
                response.put("userId", user.getId());
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody UserManipulationRequest request) {
        try {
            var user = userService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserManipulationRequest request) {
        var user = userService.update(id, request);
        return user != null? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PutMapping("/api/users/{id}/updatePoints")
    public ResponseEntity<User> updatePointsAndLevel(@PathVariable Long id, @RequestParam int points) {
        var userEntity = userService.updateLevel(id, points);

        if (userEntity != null) {
            var user = new User(
                    userEntity.getId(),
                    userEntity.getUsername(),
                    userEntity.getPoints(),
                    userEntity.getLevel()
            );
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean successful = userService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
