package com.game.tictactoe.persistence;

import jakarta.persistence.*;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "points")
    private String points;

    @Column(name = "password")
    private String password;

    public UserEntity(String username, String password, String points) {
        this.username = username;
        this.password = password;
        this.points = points;
    }

    protected UserEntity() {}

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPoints() {
        return points;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
