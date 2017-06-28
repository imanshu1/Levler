package com.example.imanshu.levler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Multiple_Invite extends AppCompatActivity {
    @Bind(R.id.sendmultiple_textview_one)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple__invite);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.multiple_invite_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Multiple Invites");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.sendmultiple_textview_one)
    public void send_single(){
        Intent i=new Intent(Multiple_Invite.this,Send_Invite.class);
        startActivity(i);
    }
}
