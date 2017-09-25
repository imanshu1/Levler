package com.example.imanshu.levler;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.imanshu.levler.adapter.AllReview_Adapter;
import com.example.imanshu.levler.apiclient.AllReviewInterface;
import com.example.imanshu.levler.pojo.FbReview;
import com.example.imanshu.levler.pojo.Message;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;


public class All_Reviews extends Fragment {


    ListView allreviews_list;

    List<Message> messageList;
    AllReview_Adapter allReview_adapter;
    SharedPreferences pref;
    String token,location_id;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        pref=getActivity().getSharedPreferences("Options", MODE_PRIVATE);
        token=pref.getString("token", "");
        location_id=pref.getString("location_id","");

        View view = inflater.inflate(R.layout.fragment_all__reviews, container, false);
        allreviews_list = (ListView) view.findViewById(R.id.allreviews_list);
        getallreviews();

        return view;

    }

    private void getallreviews() {


        messageList=new ArrayList<>();
        allReview_adapter=new AllReview_Adapter(getActivity(),messageList);


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        AllReviewInterface signup_interface=retrofit.create(AllReviewInterface.class);

        Call<FbReview> call=signup_interface.locationList(token);

        call.enqueue(new Callback<FbReview>() {
            @Override
            public void onResponse(Call<FbReview> call, Response<FbReview> response) {

                Log.i("responsecode",response.code()+"");

                if (response.code() == 400 || response.code() == 401){

                    allreviews_list.setVisibility(View.GONE);

                }
                else {
                    FbReview locationModel=response.body();
                    messageList = locationModel.getMessage();

                    allReview_adapter.addList((ArrayList<Message>) messageList);
                    allreviews_list.setAdapter(allReview_adapter);

                }

            }

            @Override
            public void onFailure(Call<FbReview> call, Throwable t) {

            }
        });


    }
}
