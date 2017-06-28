package com.example.imanshu.levler;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Review_Invites extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review__invites);

        Toolbar toolbar = (Toolbar) findViewById(R.id.review_invites_tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Reviews");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.review_pager);
        pager.setAdapter(adapter);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pager.setCurrentItem(1);

    }
}
