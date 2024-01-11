package com.game.tictactoe.web.api;

public class UserManipulationRequest {

    private String username;
    private int points;
    private String password;
    private int level;

    public UserManipulationRequest() {
    }

    public UserManipulationRequest(String username, int points, String password, int level) {
        this.username = username;
        this.points = points;
        this.password = password;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPointsString() {
        return Integer.toString(points);
    }
    public String getLevelString() {
    	return Integer.toString(level);
    }
}
