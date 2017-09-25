package com.example.imanshu.levler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.imanshu.levler.apiclient.Send_invite_interface;
import com.example.imanshu.levler.pojo.Location;
import com.example.imanshu.levler.pojo.Send_Invites_Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Send_Invite extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Bind(R.id.textview_multiple_invites)
    TextView textView;

    @Bind(R.id.sendinvites_location)
    TextView sendinvites_location;

    @Bind(R.id.sendinvites_button)
    Button sendinvites_button;
    EditText customer_name,customer_phone;
    int id;
    String token;
    Spinner spinner;
    Integer get_id;

    List<Location> locations;
    ArrayList<String> list;
    ArrayList<Integer> list_id;
    TextView send_invite_error;
    ProgressBar progressBar;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__invite);

        ButterKnife.bind(this);

        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        token=pref.getString("token", "");

        customer_name=(EditText)findViewById(R.id.customer_name);
        customer_phone=(EditText)findViewById(R.id.customer_phone);
        send_invite_error=(TextView)findViewById(R.id.send_invite_error);
        progressBar=(ProgressBar)findViewById(R.id.progressBar) ;

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        sendinvites_location.setText(message);

        Toolbar toolbar = (Toolbar) findViewById(R.id.sendinvites_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Send Invites");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        local_name();
//        spinner=(Spinner)findViewById(R.id.spinner);
//        spinner.setOnItemSelectedListener(this);

    }


//    private void local_name() {
//
//        locations=new ArrayList<>();
//        list=new ArrayList<String>();
//        list_id=new ArrayList<Integer>();
//
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("https://app.levler.co/")
//                .client(new OkHttpClient())
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();
//
//        Location_interface signup_interface=retrofit.create(Location_interface.class);
//
//        Call<LocationModel> call=signup_interface.locationList(token);
//
//        call.enqueue(new Callback<LocationModel>() {
//            @Override
//            public void onResponse(Call<LocationModel> call, ResponseModel<LocationModel> response) {
//
//                LocationModel locationModel=response.body();
//
//                for (int i=0;i<locationModel.getLocations().size();i++){
//
//                    String s=locationModel.getLocations().get(i).getName();
//                    Integer s1=locationModel.getLocations().get(i).getId();
//                    list.add(s);
//                    list_id.add(s1);
//
//                }
//                ArrayAdapter adp=new ArrayAdapter(Send_Invite.this,android.R.layout.simple_spinner_item,list);
//                spinner.setAdapter(adp);
//
//                Log.d("taggedPlaces",""+response.body());
//
//            }
//
//            @Override
//            public void onFailure(Call<LocationModel> call, Throwable t) {
//
//            }
//        });
//
//
//    }

    @OnClick(R.id.textview_multiple_invites)
    public void send_multiple()
    {
        Intent i=new Intent(Send_Invite.this,Multiple_Invite.class);
        startActivity(i);

    }

    @OnClick(R.id.sendinvites_button)
    public void setSendinvites_button(){

        viewsuccess();

        if (customer_name.getText().toString().isEmpty() || customer_phone.getText().toString().isEmpty() ){
            send_invite_error.setText("You must Enter both fields to send invite successfully");
            send_invite_error.setVisibility(View.VISIBLE);
        }
        else {
            progressBar.setVisibility(View.VISIBLE);
            Send_Invites_Model example = new Send_Invites_Model(customer_name.getText().toString(), customer_phone.getText().toString());
            OkHttpClient.Builder okbuilder = new OkHttpClient.Builder();
            okbuilder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request response = chain.request();
                    return null;
                }
            });

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("https://app.levler.co/")
                    .client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();


            Send_invite_interface signup_interface = retrofit.create(Send_invite_interface.class);

            Call<Send_Invites_Model> call = signup_interface.sendInvite(token, example);

            call.enqueue(new Callback<Send_Invites_Model>() {
                @Override
                public void onResponse(Call<Send_Invites_Model> call, Response<Send_Invites_Model> response) {
                    if (response.code() == 201 || response.code() == 201) {
                        customer_name.setText("");
                        customer_phone.setText("");
                        progressBar.setVisibility(View.GONE);
                        viewsuccess();
                    }
                    else {
                        send_invite_error.setText("Something went wrong, Please try again later!");
                        send_invite_error.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<Send_Invites_Model> call, Throwable t) {

                    send_invite_error.setText("Something went wrong, Please try again later!");
                    send_invite_error.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            });
        }
    }

    private void viewsuccess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Send_Invite.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(dialogView);

        builder.show();

//        InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

//                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        switch (parent.getId())
//        {
//            case R.id.spinner:
//                String get_value= spinner.getSelectedItem().toString();
//                if(get_value.equalsIgnoreCase("Select Category"))
//                {
//                    get_id=null;
//                }
//                else
//                {
//                    get_id=list_id.get(position);
//                    Log.i("idaccess",""+get_id);
//
//                }
//                break;
//        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }





}
