package com.game.tictactoe.web.api;

public class User {

    private long id;
    private String username;
    private int points;
    private int level;

    public User(long id, String username, int points, int level) {
        this.id = id;
        this.username = username;
        this.points = points;
        this.level = level;
    }

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
}
