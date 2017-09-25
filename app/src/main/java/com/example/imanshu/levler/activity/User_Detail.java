package com.example.imanshu.levler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imanshu.levler.Home;
import com.example.imanshu.levler.R;
import com.example.imanshu.levler.apiclient.Signup_interface;
import com.example.imanshu.levler.pojo.AccessToken;
import com.example.imanshu.levler.pojo.Signup_Model;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class User_Detail extends AppCompatActivity {

    String team_name,team_goal;
    EditText first_name,last_name,user_phone,user_email,user_password;
    Button user_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__detail);

        Intent intent = getIntent();
         team_name = intent.getStringExtra("team_name");
         team_goal = intent.getStringExtra("team_goal");

        first_name=(EditText)findViewById(R.id.first_name);
        last_name=(EditText)findViewById(R.id.last_name);
        user_phone=(EditText)findViewById(R.id.user_phone);
        user_email=(EditText)findViewById(R.id.user_email);
        user_password=(EditText)findViewById(R.id.user_password);

        user_signup=(Button)findViewById(R.id.user_signup);
        user_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

    }

    private void signup() {

        Signup_Model example=new Signup_Model(
                team_name,team_goal,first_name.getText().toString(),last_name.getText().toString(),user_email.getText().toString()
                ,user_password.getText().toString(),"active",user_phone.getText().toString());

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        Signup_interface signup_interface=retrofit.create(Signup_interface.class);
        Call<AccessToken> call=signup_interface.loginForUser(example);

        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {

                if (response.code()==201 || response.code()==201){
                    String s=response.body().getToken();
                    Intent home=new Intent(User_Detail.this,Home.class);
                    home.putExtra("token",s);
                    startActivity(home);
                    Toast.makeText(User_Detail.this, "Login success"+response.code(), Toast.LENGTH_SHORT).show();
                }

                Log.i("tokensignup",""+response.body());
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {

                Toast.makeText(User_Detail.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
