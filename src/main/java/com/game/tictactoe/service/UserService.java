package com.game.tictactoe.service;

import com.game.tictactoe.persistence.UserEntity;
import com.game.tictactoe.persistence.UserRepository;
import com.game.tictactoe.web.api.User;
import com.game.tictactoe.web.api.UserManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Handler;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<UserEntity> users = userRepository.findAll();
        return userRepository.findAll().stream()
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getUsername(),
                        userEntity.getPassword(),
                        userEntity.getPoints(),
                        userEntity.getLevel()
                ))
                .collect(Collectors.toList());
    }

    public UserEntity updatePoints(Long id, int points) {
        UserEntity user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setPoints(user.getPoints() + points);
            userRepository.save(user);
        }

        return user;
    }


    public User findById(Long id) {
        var userEntity = userRepository.findById(id);
        return userEntity.map(this::transformEntity).orElse(null);
    }

    public User create(UserManipulationRequest request) {
        var userEntity = new UserEntity(
                request.getUsername(),
                request.getPassword(),
                request.getPoints(),
                request.getLevel());
        userEntity = userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    public User update(Long id, UserManipulationRequest request) {
        var userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isEmpty()) {
            return null;
        }
        var userEntity = userEntityOptional.get();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setPoints(request.getPoints());
        userEntity.setLevel(request.getLevel());
        userRepository.save(userEntity);
        return transformEntity(userEntity);
    }

    public boolean deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }

    private User transformEntity(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getPoints(),
                userEntity.getLevel()
        );
    }

    public Object getUser() {
        return null;
    }

}