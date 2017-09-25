package com.example.imanshu.levler.pojo;

/**
 * Created by Imanshu on 8/23/2017.
 */
public class Signup_Model {
 String team_name;
    String team_goal;
    String first_name;
    String last_name;
    String email;
    String password;
    String state;
    String phone;

    public Signup_Model(String team_name, String team_goal, String first_name, String last_name, String email, String password, String state, String phone) {
        this.team_name = team_name;
        this.team_goal = team_goal;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.state = state;
        this.phone = phone;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getTeam_goal() {
        return team_goal;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }
}