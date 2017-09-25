package com.example.imanshu.levler.pojo;

/**
 * Created by Imanshu on 8/24/2017.
 */

public class Send_Invites_Model {
    String name;
    String phone;


    public Send_Invites_Model(String name, String phone) {
        this.name = name;
        this.phone = phone;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
