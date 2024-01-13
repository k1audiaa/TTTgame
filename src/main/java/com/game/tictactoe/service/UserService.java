package com.game.tictactoe.service;

import com.game.tictactoe.TicTacToeApplication;
import com.game.tictactoe.persistence.UserEntity;
import com.game.tictactoe.persistence.UserRepository;
import com.game.tictactoe.web.api.User;
import com.game.tictactoe.web.api.UserManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
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
                        userEntity.getPoints(),
                        userEntity.getLevel()
                ))
                .collect(Collectors.toList());
    }

    public UserEntity updateLevel(Long id, int points) {
        UserEntity user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setPoints(user.getPoints() + points);
            int newLevel = calculateLevel(user.getPoints());
            user.setLevel(newLevel);
            userRepository.save(user);
        }

        return user;
    }

    public int calculateLevel(int points) {
        if (points >= 100 && points < 200) {
            return 1;
        } else if (points >= 200 && points < 300) {
            return 2;
        } else if (points >= 300 && points < 400) {
            return 3;
        } else if (points >= 400 && points < 500) {
            return 4;
        } else if (points >= 500 && points < 600) {
            return 5;
        } else if (points >= 600 && points <700) {
            return 6;
        } else if (points >= 700 && points < 800) {
            return 7;
        } else if (points >= 800 && points < 900) {
            return 8;
        } else if (points >= 900 && points < 1000) {
            return 9;
        } else if (points >= 1000) {
            return 10;
        } else {
            return 0;
        }
    }

    public User findById(Long id) {
        var userEntity = userRepository.findById(id);
        return userEntity.map(this::transformEntity).orElse(null);
    }

    public User create(UserManipulationRequest request) {
        var userEntity = new UserEntity(
                request.getUsername(),
                request.getPoints(),
                request.getLevel()
        );
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
                userEntity.getPoints(),
                userEntity.getLevel()
        );
    }

    public boolean doesUserExistByUsername(String username) {
        return userRepository.findAllByUsername(username).size() > 0;
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Object getUser() {
        return null;
    }

    public TicTacToeApplication getGameById(long l) {
        return null;
    }
}