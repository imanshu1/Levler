package com.example.imanshu.levler.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.imanshu.levler.R;
import com.example.imanshu.levler.adapter.AllReview_Adapter;
import com.example.imanshu.levler.adapter.MyReviewsAdapter;
import com.example.imanshu.levler.apiclient.Review_interface;
import com.example.imanshu.levler.pojo.Message;
import com.example.imanshu.levler.pojo.ResponseModel;
import com.example.imanshu.levler.pojo.Reviews;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllReviewPage extends AppCompatActivity {
    ListView reviews_List;
    List<ResponseModel> responseList;
    List<Message> responselist1;
    MyReviewsAdapter myReviewsAdapter;
    AllReview_Adapter allReview_adapter;
    SharedPreferences pref;
    String token,location_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_review_page2);


        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        token=pref.getString("token", "");
        location_id=pref.getString("location_id","");
        //location_id="62";
        reviews_List=(ListView)findViewById(R.id.reviews_List);

        getgooglereviews();
    }



    private void getgooglereviews() {

        Reviews location_idModel=new Reviews(location_id);

        responseList=new ArrayList<>();
        myReviewsAdapter=new MyReviewsAdapter(this,responseList);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Review_interface signup_interface=retrofit.create(Review_interface.class);

        Call<Reviews> call=signup_interface.locationList(token);

        call.enqueue(new Callback<Reviews>() {
            @Override
            public void onResponse(Call<Reviews> call, Response<Reviews> response) {

                Log.i("responsecode",response.code()+"");

                Reviews locationModel=response.body();
                responseList = locationModel.getResponse();

                myReviewsAdapter.addList((ArrayList<ResponseModel>) responseList);
                reviews_List.setAdapter(myReviewsAdapter);

            }

            @Override
            public void onFailure(Call<Reviews> call, Throwable t) {

            }
        });

    }

}

