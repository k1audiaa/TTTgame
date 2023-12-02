package com.game.tictactoe.api;

public class User {

    private long id;
    private String username;
    private String password;
    private String points;

    public User(long id, String username, String password, String points) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
    	this.username = username;
    }

    public void setPassword(String password) {
    	this.password = password;
    }
}
