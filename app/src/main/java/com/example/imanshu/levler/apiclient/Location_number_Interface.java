package com.example.imanshu.levler.apiclient;

import com.example.imanshu.levler.model.Location_Name;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Imanshu on 9/25/2017.
 */

public interface Location_number_Interface {
    @Headers({"Content-Type: application/json"})

    @GET("api/v1/total/locations")
    Call<Location_Name> location_no(@Header("Authorization") String s);

}
