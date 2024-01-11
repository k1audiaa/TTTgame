package com.game.tictactoe.web.api;

public class User {

    private long id;
    private String username;
    private String password;
    private int points;
    private int level;

    public User(long id, String username, String password, int points, int level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.points = points;
        this.level = level;
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

    public int getPoints() {
        return points;
    }

    public int getLevel() {
    	return level;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
    	this.username = username;
    }

    public void setLevel(int level) {
    	this.level = level;
    }

    public void setPassword(String password) {
    	this.password = password;
    }
}
