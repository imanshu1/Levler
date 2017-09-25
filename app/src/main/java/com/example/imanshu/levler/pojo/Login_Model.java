package com.example.imanshu.levler.pojo;

/**
 * Created by Imanshu on 8/24/2017.
 */

public class Login_Model {
    String email;
    String password;
    String token;
    Integer location_id;
    Integer team_goal;

    public Login_Model(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public Integer getTeam_goal() {
        return team_goal;
    }

    public void setTeam_goal(Integer team_goal) {
        this.team_goal = team_goal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
