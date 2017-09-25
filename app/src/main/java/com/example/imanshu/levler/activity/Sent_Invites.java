package com.example.imanshu.levler.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.imanshu.levler.R;
import com.example.imanshu.levler.adapter.AllInvites_Adapter;
import com.example.imanshu.levler.apiclient.AllInvites_interface;
import com.example.imanshu.levler.pojo.AllInvitesModel;
import com.example.imanshu.levler.pojo.Datum;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sent_Invites extends AppCompatActivity {
    ListView list_all_invites;
    List<Datum> datumList;
    AllInvites_Adapter allInvites_adapter;
    SharedPreferences pref;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent__invites);

        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        token=pref.getString("token", "");

        list_all_invites=(ListView)findViewById(R.id.list_all_invites) ;

        Toolbar toolbar = (Toolbar) findViewById(R.id.allinvites_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sent Invites");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getallinvites();
    }

    private void getallinvites() {

        datumList=new ArrayList<>();
        allInvites_adapter=new AllInvites_Adapter(this,datumList);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        AllInvites_interface signup_interface=retrofit.create(AllInvites_interface.class);

        Call<AllInvitesModel> call=signup_interface.invitesList(token);

        call.enqueue(new Callback<AllInvitesModel>() {
            @Override
            public void onResponse(Call<AllInvitesModel> call, Response<AllInvitesModel> response) {

                AllInvitesModel locationModel=response.body();

                datumList = locationModel.getData();
                allInvites_adapter.addList((ArrayList<Datum>) datumList);
                list_all_invites.setAdapter(allInvites_adapter);

            }

            @Override
            public void onFailure(Call<AllInvitesModel> call, Throwable t) {

            }
        });

    }

}
