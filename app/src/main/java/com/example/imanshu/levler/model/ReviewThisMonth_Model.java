package com.example.imanshu.levler.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Imanshu on 9/20/2017.
 */

public class ReviewThisMonth_Model {

    @SerializedName("data")
    @Expose
    private Integer data;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
