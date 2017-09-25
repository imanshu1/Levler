package com.example.imanshu.levler.apiclient;

import com.example.imanshu.levler.pojo.AccessToken;
import com.example.imanshu.levler.pojo.Signup_Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Imanshu on 8/24/2017.
 */

public interface Signup_interface {
    @Headers("Content-Type:application/json")

    @POST("api/v1/signup_form/signup")
    Call<AccessToken> loginForUser(@Body Signup_Model example);
}
