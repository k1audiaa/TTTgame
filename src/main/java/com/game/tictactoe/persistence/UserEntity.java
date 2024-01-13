package com.game.tictactoe.persistence;

import jakarta.persistence.*;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username", unique=true)
    private String username;

    @Column(name = "points")
    private int points=100;

    @Column(name= "level" )
    private int level=1;

    public UserEntity(String username, int points, int level) {
        this.username = username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setLevel(int level) {
    	this.level = level;
    }

}

