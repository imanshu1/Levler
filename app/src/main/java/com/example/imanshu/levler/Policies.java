package com.example.imanshu.levler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Policies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies);

        Toolbar toolbar = (Toolbar) findViewById(R.id.policies_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Policies");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
