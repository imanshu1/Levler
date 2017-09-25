package com.example.imanshu.levler;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.imanshu.levler.adapter.MyReviewsAdapter;
import com.example.imanshu.levler.apiclient.Review_interface;
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

import static android.content.Context.MODE_PRIVATE;


public class My_Invites_Review extends Fragment {

    ListView myreviews_list;
    Adapter adapter1;

    SimpleAdapter adapter;

    ListView reviews_List;
    List<ResponseModel> responseList;
    MyReviewsAdapter myReviewsAdapter;
    SharedPreferences pref;
    String token,location_id;

    int i = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        pref=getActivity().getSharedPreferences("Options", MODE_PRIVATE);
        token=pref.getString("token", "");
        location_id=pref.getString("location_id","");

        View view =inflater.inflate(R.layout.fragment_my__invites__review, container, false);
        myreviews_list=(ListView)view.findViewById(R.id.my_invites_list);

        getgooglereviews();

        return view;
    }



    private void getgooglereviews() {

        Reviews location_idModel=new Reviews(location_id);

        responseList=new ArrayList<>();
        myReviewsAdapter=new MyReviewsAdapter(getActivity(),responseList);

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
                myreviews_list.setAdapter(myReviewsAdapter);

            }

            @Override
            public void onFailure(Call<Reviews> call, Throwable t) {

            }
        });

    }

}