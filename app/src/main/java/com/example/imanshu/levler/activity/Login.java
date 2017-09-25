package com.example.imanshu.levler.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.imanshu.levler.Home;
import com.example.imanshu.levler.R;
import com.example.imanshu.levler.apiclient.Login_interface;
import com.example.imanshu.levler.pojo.Login_Model;

import java.io.IOException;

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

public class Login extends AppCompatActivity {

    @Bind(R.id.login_email) TextInputEditText login_email;
    @Bind(R.id.login_password)  TextInputEditText login_password;

    @Bind(R.id.login_signin) Button login_signin;
    @Bind(R.id.login_textview) TextView textView;

    private AwesomeValidation awesomeValidation;
    String accesstoken;
    String locationid;
    SharedPreferences.Editor editor;
    TextView error;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE);
        editor=pref.edit();

        error=(TextView)findViewById(R.id.error);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.login_email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        //awesomeValidation.addValidation(this, R.id.login_email, Patterns.digitsAndPlusOnly(), R.string.emailerror);

    }

    @OnClick(R.id.login_signin)
    public void signin(){

        progressBar.setVisibility(View.VISIBLE);

        String s=login_email.getText().toString();
        String s1=login_password.getText().toString();

        if (s.isEmpty() || s1.isEmpty()){

            error.setText("E-mail and Password fields can't be Empty");
            error.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);

        }
        else {
            Login_Model example = new Login_Model(s, s1);
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

            Login_interface login_interface = retrofit.create(Login_interface.class);
            Call<Login_Model> call1 = login_interface.ForUser(example);

            call1.enqueue(new Callback<Login_Model>() {
                @Override
                public void onResponse(Call<Login_Model> call, Response<Login_Model> response) {

                    Log.i("tagged", "" + response.body());
                    if (response.code() == 200 || response.code() == 201) {

                        accesstoken = response.body().getToken();
                        locationid=""+response.body().getLocation_id();
                        String team_goal=""+response.body().getTeam_goal();
                        Log.i("codelogin",""+locationid);
                        editor.putString("token", accesstoken);
                        editor.putString("location_id",""+locationid);
                        editor.putString("team_goal",""+team_goal);
                        editor.commit();
                        error.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        Intent home = new Intent(Login.this, Home.class);
                        home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(home);
                    } else {
                        error.setText("Please Enter a valid E-mail and Password");
                        error.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }

                }

                @Override
                public void onFailure(Call<Login_Model> call, Throwable t) {

                    error.setText("Please Enter a valid E-mail and Password");
                    error.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            });

        }

    }

    @OnClick(R.id.login_textview)
    public void forgot_password(){


    }

}
