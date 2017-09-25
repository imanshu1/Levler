package com.example.imanshu.levler.apiclient;

import com.example.imanshu.levler.pojo.Send_Invites_Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Imanshu on 8/24/2017.
 */

public interface Send_invite_interface {

    @Headers({"Content-Type: application/json"})

    @POST("api/v1/employe_invites")
    Call<Send_Invites_Model> sendInvite(@Header("Authorization") String s,@Body Send_Invites_Model example);
}
