package com.example.imanshu.levler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.imanshu.levler.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Signup extends AppCompatActivity {

    @Bind(R.id.user_detail_button)
    Button user_detail_button;

    EditText team_name,team_goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);

        team_name=(EditText)findViewById(R.id.team_name);
        team_goal=(EditText)findViewById(R.id.team_goal);

    }

    @OnClick(R.id.user_detail_button)
    public void setUser_detail_button(){

        Intent i=new Intent(Signup.this,User_Detail.class);
        i.putExtra("team_name",team_name.getText().toString());
        i.putExtra("team_goal",team_goal.getText().toString());
        startActivity(i);
    }
}
