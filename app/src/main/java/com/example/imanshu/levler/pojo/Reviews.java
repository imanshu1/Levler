package com.example.imanshu.levler.pojo;

/**
 * Created by Imanshu on 9/19/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Reviews {

    String location_id;

    public Reviews(String location_id) {
        this.location_id = location_id;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    @SerializedName("response")
    @Expose
    private List<ResponseModel> response = null;

    public List<ResponseModel> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseModel> response) {
        this.response = response;
    }

}