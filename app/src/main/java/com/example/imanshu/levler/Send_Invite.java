package com.example.imanshu.levler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Send_Invite extends AppCompatActivity {

    @Bind(R.id.textview_multiple_invites)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__invite);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.sendinvites_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Send Invites");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.textview_multiple_invites)
    public void send_multiple()
    {
        Intent i=new Intent(Send_Invite.this,Multiple_Invite.class);
        startActivity(i);
    }
}
