package com.example.imanshu.levler;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {

    @Bind(R.id.login_email) TextInputEditText login_email;
    @Bind(R.id.login_password)  TextInputEditText login_password;

    @Bind(R.id.login_signin) Button login_signin;
    @Bind(R.id.login_textview) TextView textView;

    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.login_email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
       // awesomeValidation.addValidation(this, R.id.login_email, Patterns.digitsAndPlusOnly(), R.string.emailerror);

    }

    @OnClick(R.id.login_signin)
    public void signin(){

        Intent i=new Intent(Login.this,Home.class);
        startActivity(i);
//        if (awesomeValidation.validate())
//        {
//
//        }
    }
    @OnClick(R.id.login_textview)
    public void forgot_password(){
        Intent j=new Intent(Login.this,Forgot_Password.class);
        startActivity(j);
    }

}
