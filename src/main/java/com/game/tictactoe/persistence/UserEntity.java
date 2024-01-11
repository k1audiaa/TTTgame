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
    private int points;

    @Column(name = "password")
    private String password;

    @Column(name= "level" )
    private int level;

    public UserEntity(String username, String password, int points, int level) {
        this.username = username;
        this.password = password;
        this.points = points;
        this.level = level;
    }

    protected UserEntity() {}

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
    }

    public int getLevel() {
    	return level;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setLevel(int level) {
    	this.level = level;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

