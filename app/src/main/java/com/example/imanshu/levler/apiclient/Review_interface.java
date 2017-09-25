package com.example.imanshu.levler.apiclient;

import com.example.imanshu.levler.pojo.Reviews;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Imanshu on 8/28/2017.
 */

public interface Review_interface {
//
    @Headers({"Content-Type: application/json"})

    @POST("api/v1/employe/google_reviews")
    Call<Reviews> locationList(@Header("Authorization") String s);

}
