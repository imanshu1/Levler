package com.example.imanshu.levler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Review_Invites extends AppCompatActivity {

    TextView tool_g,tool_f,button_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review__invites);

         tool_f=(TextView)findViewById(R.id.tool_f);
        tool_g=(TextView)findViewById(R.id.tool_g);
        button_back=(TextView)findViewById(R.id.button_back);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.review_invites_tool_bar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Reviews");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        final ViewPager pager = (ViewPager) findViewById(R.id.review_pager);
        pager.setAdapter(adapter);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pager.setCurrentItem(0);
        changeColors(0);



        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Review_Invites.this, Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });


        tool_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
                changeColors(1);
            }
        });

        tool_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColors(0);
                pager.setCurrentItem(0);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Review_Invites.this, Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void changeColors(final int pos) {
        tool_g.setTextColor(getResources().getColor(R.color.fade));
        tool_f.setBackgroundResource(R.drawable.dotted_border);
        tool_f.setTextColor(getResources().getColor(R.color.fade));
        tool_g.setBackgroundResource(R.drawable.dotted_border);

        switch (pos) {
            case 0:
                tool_g.setTextColor(getResources().getColor(R.color.main_green));
                tool_g.setBackgroundColor(getResources().getColor(R.color.fade));
                tool_f.setBackgroundResource(R.drawable.dotted_border);
                break;
            case 1:
                tool_f.setTextColor(getResources().getColor(R.color.main_green));
                tool_f.setBackgroundColor(getResources().getColor(R.color.fade));
                tool_g.setBackgroundResource(R.drawable.dotted_border);
                break;

            default:
                break;
        }
    }
}
