package com.example.imanshu.levler.apiclient;

import com.example.imanshu.levler.model.Location_Name;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Imanshu on 9/20/2017.
 */

public interface SentInviteCount_intrface {

    @Headers({"Content-Type: application/json"})

    @GET("api/v1/total/invites")
    Call<Location_Name> sentinvite_count(@Header("Authorization") String s);

}
