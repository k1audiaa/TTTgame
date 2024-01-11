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

    @Column(name= "level" )
    private String level;

    public UserEntity(String username, String password, String points, String level) {
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

    public String getPoints() {
        return points;
    }

    public String getLevel() {
    	return level;
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

    public void setLevel(String level) {
    	this.level = level;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

