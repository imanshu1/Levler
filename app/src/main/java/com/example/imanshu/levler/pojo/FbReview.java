package com.example.imanshu.levler.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Imanshu on 9/20/2017.
 */

public class FbReview {

    @SerializedName("message")
    @Expose
    private List<Message> message = null;

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
