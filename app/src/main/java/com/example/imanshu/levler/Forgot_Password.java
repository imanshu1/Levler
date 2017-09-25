package com.example.imanshu.levler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.imanshu.levler.activity.Login;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Forgot_Password extends AppCompatActivity {

    @Bind(R.id.forgot_textview)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.forgot_textview)
    public void signin_screen(){
        Intent i=new Intent(Forgot_Password.this,Login.class);
        startActivity(i);
    }
}
