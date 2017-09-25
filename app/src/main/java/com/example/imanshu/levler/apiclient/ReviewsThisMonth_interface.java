package com.example.imanshu.levler.apiclient;

import com.example.imanshu.levler.model.ReviewThisMonth_Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Imanshu on 9/20/2017.
 */

public interface ReviewsThisMonth_interface {

    @Headers({"Content-Type: application/json"})

    @GET("api/v1/month/reviews")
    Call<ReviewThisMonth_Model> thismonthreview(@Header("Authorization") String s);

}
