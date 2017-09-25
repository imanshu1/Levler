package com.example.imanshu.levler.apiclient;

import com.example.imanshu.levler.pojo.Login_Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Imanshu on 8/23/2017.
 */

public interface Login_interface {

    @Headers("Content-Type:application/json")

    @POST("api/v1/fleet/login")
    Call<Login_Model> ForUser(@Body Login_Model example);
}
