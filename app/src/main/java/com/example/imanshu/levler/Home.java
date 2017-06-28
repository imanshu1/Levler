package com.example.imanshu.levler;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Home extends AppCompatActivity {
    @Bind(R.id.icon_menu) ImageView icon_menu;
    @Bind(R.id.home_layout) DrawerLayout drawerLayout;
    @Bind(R.id.tool_bar) Toolbar toolbar;
    @Bind(R.id.home_textview_review) TextView home_textview_review;
    @Bind(R.id.home_textview_invites) TextView home_textview_invites;
    @Bind(R.id.home_button_sendinvites)Button home_button_sendinvites;
    @Bind(R.id.home_button_allreviews)Button home_button_allreviews;
    @Bind(R.id.home_button_allleaders)Button home_button_allleaders;
   TextView inflate_textview;

    ListView home_list_reviews;

    String []temp_data={"review 1","review 2","review 3","review 4","review 5","review 6","review 7","review 8","review 9"};

    private ProgressBar progressBar;
    private int progressStatus = 15;
    LinearLayout home_layout_inflate,home_layout_leader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        ////////////////////////toolbar////////////////////////////////////////////////////////



       ////////////////////////////////////////////////////////////////////////////////////////

        //////////////////////open navigation drawer////////////////////////////////////////

        final NavigationView navigationView=(NavigationView)findViewById(R.id.home_navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);

                drawerLayout.closeDrawers();

                switch (item.getItemId())
                {
                    case R.id.menu_home:
                       drawerLayout.closeDrawer(navigationView);
                        break;

                    case R.id.menu_aboutus:
                        Intent about=new Intent(Home.this,About_Us.class);
                        startActivity(about);
                        break;

                    case R.id.menu_policies:
                        Intent policies=new Intent(Home.this,Policies.class);
                        startActivity(policies);
                        break;
                    case R.id.menu_logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
                        builder.setMessage("Are you sure?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent login=new Intent(Home.this,Login.class);
                                startActivity(login);
                            }
                        })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();
                        break;

                    case R.id.menu_rateapp:
                        Dialog dialog=new Dialog(Home.this);
                        dialog.setContentView(R.layout.home_rating);
                        dialog.show();
                        break;


                }


                return true;
            }
        });

        //////////////////////close navigation drawer////////////////////////////////////////

        /////////////////////////////////inflator 2/////////////////////////////////

        home_layout_leader=(LinearLayout)findViewById(R.id.home_layout_leader);
        LayoutInflater inflater1=LayoutInflater.from(Home.this);

        for(int i=1;i<=3;i++)
        {
            View inflated_leader=inflater1.inflate(R.layout.inflator_leader_board,null,false);

            TextView rank_infl_las=(TextView)inflated_leader.findViewById(R.id.rank_infl_las);
            rank_infl_las.setText(i+"");

            home_layout_leader.addView(inflated_leader);
        }

        ////////////////////////////////////////////////////////////////////////////////////
        
        ///////////////////////////////INFLATOR///////////////////////////////////////////////

        home_layout_inflate=(LinearLayout)findViewById(R.id.home_layout_inflate);

        LayoutInflater inflater = LayoutInflater.from(Home.this);



        for (int i = 1; i<=4; i++) {

            View inflatedLayout= inflater.inflate(R.layout.inflate_myreview, null, false);

//            inflate_textview=(TextView)inflatedLayout.findViewById(R.id.inflate_textview);
//
//            inflate_textview.setText("hello i am "+i+" number inflater");

            home_layout_inflate.addView(inflatedLayout);
        }

///////////////////////////////INFLATOR///////////////////////////////////////////////

///////////////////////////list view////////////////////////////////////////////////////////////////
//        home_list_reviews=(ListView)findViewById(R.id.home_list_reviews);
//        ArrayAdapter adop=new ArrayAdapter(Send_Invites.this,android.R.layout.simple_list_item_1,temp_data);
//        home_list_reviews.setAdapter(adop);

/////////////////////////////////////////////////////////////////////////////////////////////////////////
        progressBar=(ProgressBar)findViewById(R.id.home_progressbar);
        progressBar.setProgress(progressStatus);

        int i=75,b=55;

        home_textview_review.setText(" "+b+" ");

        home_textview_invites.setText(i+" Invites");

    }

    @OnClick(R.id.icon_menu)
    public void open_drawer(){
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    @OnClick(R.id.home_button_sendinvites)
    public void send_invites()
    {
        startActivity(new Intent(Home.this,Send_Invite.class));
    }

    @OnClick(R.id.home_button_allreviews)
    public void allreviews()
    {
        startActivity(new Intent(Home.this,Review_Invites.class));
    }

    @OnClick(R.id.home_button_allleaders)
    public void allleaders()
    {
        startActivity(new Intent(Home.this,Leader_board.class));
    }
}
