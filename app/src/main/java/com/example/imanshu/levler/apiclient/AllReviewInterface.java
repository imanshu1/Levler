package com.example.imanshu.levler.apiclient;

import com.example.imanshu.levler.pojo.FbReview;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Imanshu on 9/20/2017.
 */

public interface AllReviewInterface {
    @Headers({"Content-Type: application/json"})

    @GET("api/v1/employe/facebook_reviews")
    Call<FbReview> locationList(@Header("Authorization") String s);

}
