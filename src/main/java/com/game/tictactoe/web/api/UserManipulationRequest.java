package com.game.tictactoe.web.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserManipulationRequest {

    private String username;
    private int points;
    private int level;

    public UserManipulationRequest() {
    }

    public UserManipulationRequest(String username,  int points, int level) {
        this.username = username;
        this.points = points;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
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

    public int getLevel() {
    	return level;
    }
}
