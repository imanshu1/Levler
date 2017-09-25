package com.example.imanshu.levler.apiclient;

import com.example.imanshu.levler.pojo.AllInvitesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Imanshu on 8/30/2017.
 */

public interface AllInvites_interface {

    @Headers({"Content-Type: application/json"})

    @GET("api/v1/employe_invites/all_invites")
    Call<AllInvitesModel> invitesList(@Header("Authorization") String s);
}
