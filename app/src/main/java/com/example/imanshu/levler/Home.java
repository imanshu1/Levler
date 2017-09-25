package com.example.imanshu.levler;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.imanshu.levler.activity.Login;
import com.example.imanshu.levler.activity.Sent_Invites;
import com.example.imanshu.levler.apiclient.AllReviewInterface;
import com.example.imanshu.levler.apiclient.Locationname_interface;
import com.example.imanshu.levler.apiclient.Overall_Rating;
import com.example.imanshu.levler.apiclient.Review_interface;
import com.example.imanshu.levler.apiclient.ReviewsThisMonth_interface;
import com.example.imanshu.levler.apiclient.SentInviteCount_intrface;
import com.example.imanshu.levler.model.Location_Name;
import com.example.imanshu.levler.model.ReviewThisMonth_Model;
import com.example.imanshu.levler.pojo.FbReview;
import com.example.imanshu.levler.pojo.ResponseModel;
import com.example.imanshu.levler.pojo.Reviews;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity {
    @Bind(R.id.icon_menu)
    ImageView icon_menu;
    @Bind(R.id.home_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.tool_bar)
    Toolbar toolbar;
    @Bind(R.id.home_textview_review)
    TextView home_textview_review;
    @Bind(R.id.total_of_reviews)
    TextView total_of_reviews;
    @Bind(R.id.home_textview_invites)
    TextView home_textview_invites;
    @Bind(R.id.textview_progress_left)
    TextView textview_progress_left;
    @Bind(R.id.location_text)
    TextView location_text;
    @Bind(R.id.overall_rating)
    TextView overall_rating;
    @Bind(R.id.textview_progress_done)
    TextView textview_progress_done;
    @Bind(R.id.home_button_sendinvites)
    Button home_button_sendinvites;
    @Bind(R.id.home_button_allreviews)
    Button home_button_allreviews;
//    @Bind(R.id.home_button_allleaders)
//    Button home_button_allleaders;
    TextView inflate_textview;

    ListView home_list_reviews;
    List<ResponseModel> responseModelList;
    String []temp_data={"review 1","review 2","review 3","review 4","review 5","review 6","review 7","review 8","review 9"};
    String token,location_id,team_goal,total_reviews;

    int size1,rvcount;


    private ProgressBar progressBar;
    private int progressStatus = 15;
    LinearLayout home_layout_inflate,home_layout_leader;
    LayoutInflater inflater;

    List<ResponseModel> locations;
    ArrayList<String> list;
    ArrayList<Integer> list_id;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        token=pref.getString("token", "");
        location_id=pref.getString("location_id", "");
        team_goal=pref.getString("team_goal", "");
        textview_progress_left.setText(team_goal);
        //location_id="62";

        home_layout_inflate=(LinearLayout)findViewById(R.id.home_layout_inflate);
        inflater = LayoutInflater.from(Home.this);

        local_name();
        location();
        overallrating();


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

                    case R.id.menu_allinvites:
                        Intent sentInvites=new Intent(Home.this,Sent_Invites.class);
                        startActivity(sentInvites);
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
                                Intent home = new Intent(Home.this, Login.class);
                                home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(home);
                            }
                        })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();
                        break;

                    case R.id.menu_rateapp:
//                        Dialog dialog=new Dialog(Home.this);
//                        dialog.setContentView(R.layout.home_rating);
//                        dialog.show();

                        Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
                        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        try {
                            startActivity(goToMarket);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
                        }

                        break;

                }
                return true;
            }
        });

        //////////////////////close navigation drawer////////////////////////////////////////

        /////////////////////////////////inflator 2/////////////////////////////////
//
//        home_layout_leader=(LinearLayout)findViewById(R.id.home_layout_leader);
//        LayoutInflater inflater1=LayoutInflater.from(Home.this);
//
//        for(int i=1;i<=3;i++)
//        {
//            View inflated_leader=inflater1.inflate(R.layout.inflator_leader_board,null,false);
//
//            TextView rank_infl_las=(TextView)inflated_leader.findViewById(R.id.rank_infl_las);
//            rank_infl_las.setText(i+"");
//
//            home_layout_leader.addView(inflated_leader);
//        }

        ////////////////////////////////////////////////////////////////////////////////////
        
        ///////////////////////////////INFLATOR///////////////////////////////////////////////



///////////////////////////////INFLATOR///////////////////////////////////////////////
        progressBar=(ProgressBar)findViewById(R.id.home_progressbar);
        progressApi();
        thismonthReviews();

        int i=75;

    }

    private void progressApi() {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        SentInviteCount_intrface signup_interface=retrofit.create(SentInviteCount_intrface.class);

        Call<Location_Name> call=signup_interface.sentinvite_count(token);

        call.enqueue(new Callback<Location_Name>() {
            @Override
            public void onResponse(Call<Location_Name> call, Response<Location_Name> response) {

                if (response.code()==400 || response.code()==401 || response.code()==404){
                    textview_progress_done.setText(""+0);
                }
                else {

                    textview_progress_done.setText(response.body().getData());

                    int g = Integer.parseInt(response.body().getData());
                    int y = Integer.parseInt(team_goal);

                    int per = (g / y) * 100;

                    progressBar.setProgress(per);
                }

            }

            @Override
            public void onFailure(Call<Location_Name> call, Throwable t) {

            }
        });

    }

    private void overallrating() {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Overall_Rating signup_interface=retrofit.create(Overall_Rating.class);

        Call<Location_Name> call=signup_interface.overallRating(token);

        call.enqueue(new Callback<Location_Name>() {
            @Override
            public void onResponse(Call<Location_Name> call, Response<Location_Name> response) {

                overall_rating.setText(response.body().getData());

            }

            @Override
            public void onFailure(Call<Location_Name> call, Throwable t) {

            }
        });
    }

    private void location() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Locationname_interface signup_interface=retrofit.create(Locationname_interface.class);

        Call<Location_Name> call=signup_interface.locationName(token);

        call.enqueue(new Callback<Location_Name>() {
            @Override
            public void onResponse(Call<Location_Name> call, Response<Location_Name> response) {

                location_text.setText(response.body().getData());

            }

            @Override
            public void onFailure(Call<Location_Name> call, Throwable t) {

            }
        });
    }

    private void thismonthReviews() {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        ReviewsThisMonth_interface signup_interface=retrofit.create(ReviewsThisMonth_interface.class);

        Call<ReviewThisMonth_Model> call=signup_interface.thismonthreview(token);

        call.enqueue(new Callback<ReviewThisMonth_Model>() {
            @Override
            public void onResponse(Call<ReviewThisMonth_Model> call, Response<ReviewThisMonth_Model> response) {

                total_reviews=""+response.body().getData();

                int h=Integer.parseInt(team_goal);
                int f=Integer.parseInt(total_reviews);
                int r=h-f;

                home_textview_review.setText(" "+r+" ");
                home_textview_invites.setText(team_goal+" Invites");

                Log.d("taggedPlaces1",""+total_reviews);

            }

            @Override
            public void onFailure(Call<ReviewThisMonth_Model> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("resumed","resumed");
    }

    private void local_name() {

        Reviews example = new Reviews(location_id);
        locations=new ArrayList<>();
        list=new ArrayList<String>();
        list_id=new ArrayList<Integer>();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Review_interface signup_interface=retrofit.create(Review_interface.class);

        Call<Reviews> call=signup_interface.locationList(token);

        call.enqueue(new Callback<Reviews>() {
            @Override
            public void onResponse(Call<Reviews> call, Response<Reviews> response) {

                int size=0;
                Reviews reviews=response.body();

                rvcount=Integer.parseInt(""+reviews.getResponse().size());

                total_of_reviews.setText(""+rvcount);

                getallreviews();

                if (reviews.getResponse().size()>2){
                    size=2;
                }
                else {
                    size=reviews.getResponse().size()-1;

                }

                for (int i = 0; i<=size; i++) {

                    View inflatedLayout= inflater.inflate(R.layout.inflate_myreview, null, false);
                    TextView myreview_name=(TextView)inflatedLayout.findViewById(R.id.myreview_name);
                    TextView myreviews_review=(TextView)inflatedLayout.findViewById(R.id.myreviews_review);
                    ImageView myreview_rounded_view=(ImageView)inflatedLayout.findViewById(R.id.myreview_rounded_view);
                    RatingBar myreview_ratingbar=(RatingBar) inflatedLayout.findViewById(R.id.myreview_ratingbar);
                    TextView myreviews_review_Text=(TextView)inflatedLayout.findViewById(R.id.myreviews_review_Text);

                    if (reviews.getResponse().get(i).getComment().length()>50 ){
                        myreviews_review.setVisibility(View.VISIBLE);
                        myreviews_review.setText(reviews.getResponse().get(i).getComment());
                        myreviews_review_Text.setVisibility(View.GONE);
                    }
                    else {
                        myreviews_review_Text.setVisibility(View.VISIBLE);
                        myreviews_review_Text.setText(" "+reviews.getResponse().get(i).getComment());
                        myreviews_review.setVisibility(View.GONE);
                    }


                    myreview_name.setText(reviews.getResponse().get(i).getName());
                    Log.i("erro",""+reviews.getResponse().get(i).getComment());

                   // myreviews_review.setText(" "+reviews.getResponse().get(i).getComment());

                    Picasso.with(getApplicationContext()).load(reviews.getResponse().get(i).getSrc()).into(myreview_rounded_view);
                    myreview_ratingbar.setRating(reviews.getResponse().get(i).getRating());

//           inflate_textview=(TextView)inflatedLayout.findViewById(R.id.inflate_textview);
//            inflate_textview.setText("hello i am "+i+" number inflater");

                    home_layout_inflate.addView(inflatedLayout);
                }


                Log.d("taggedPlaces",""+response.body());

            }

            @Override
            public void onFailure(Call<Reviews> call, Throwable t) {

            }
        });
    }

    private void getallreviews() {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://app.levler.co/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        AllReviewInterface signup_interface=retrofit.create(AllReviewInterface.class);

        Call<FbReview> call=signup_interface.locationList(token);

        call.enqueue(new Callback<FbReview>() {
            @Override
            public void onResponse(Call<FbReview> call, Response<FbReview> response) {

                Log.i("responsecode",response.code()+"");

                if (response.code() == 400 || response.code() == 401){

                }
                else {

                    //rvcount=Integer.parseInt(""+response.body().getMessage().size());
                    int rvcountfb=Integer.parseInt(""+response.body().getMessage().size());

                    int j=rvcountfb+rvcount;
                    total_of_reviews.setText(""+j);

                    if (response.body().getMessage().size()>1){
                        size1=1;

                    }
                    else {
                        size1=response.body().getMessage().size()-1;

                    }

                    for (int i = 0; i<=size1; i++) {

                        View inflatedLayout= inflater.inflate(R.layout.inflate_myreview, null, false);
                        TextView myreview_name=(TextView)inflatedLayout.findViewById(R.id.myreview_name);
                        TextView myreviews_review=(TextView)inflatedLayout.findViewById(R.id.myreviews_review);
                        ImageView myreview_rounded_view=(ImageView)inflatedLayout.findViewById(R.id.myreview_rounded_view);
                        RatingBar myreview_ratingbar=(RatingBar) inflatedLayout.findViewById(R.id.myreview_ratingbar);

                        myreview_name.setText(response.body().getMessage().get(i).getName());
                        Log.i("erro",""+response.body().getMessage().get(i).getComment());

                        TextView myreviews_review_Text=(TextView)inflatedLayout.findViewById(R.id.myreviews_review_Text);

                        if (response.body().getMessage().get(i).getComment().length()>50 ){
                            myreviews_review.setVisibility(View.VISIBLE);
                            myreviews_review.setText(response.body().getMessage().get(i).getComment());
                            myreviews_review_Text.setVisibility(View.GONE);
                        }
                        else {
                            myreviews_review_Text.setVisibility(View.VISIBLE);
                            myreviews_review_Text.setText(" "+response.body().getMessage().get(i).getComment());
                            myreviews_review.setVisibility(View.GONE);
                        }

                        Picasso.with(getApplicationContext()).load(response.body().getMessage().get(i).getSrc()).into(myreview_rounded_view);
                        myreview_ratingbar.setRating(response.body().getMessage().get(i).getRating());

                        home_layout_inflate.addView(inflatedLayout);
                    }
                }

            }

            @Override
            public void onFailure(Call<FbReview> call, Throwable t) {

            }
        });


    }

    @OnClick(R.id.icon_menu)
    public void open_drawer(){
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    @OnClick(R.id.home_button_sendinvites)
    public void send_invites()
    {
        Intent home=new Intent(Home.this,Send_Invite.class);
        home.putExtra("token",token);
        home.putExtra("message", location_text.getText().toString());
        startActivity(home);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent home = new Intent(Home.this, Login.class);
        home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(home);
    }

    @OnClick(R.id.home_button_allreviews)
    public void allreviews()
    {
        Intent intent=new Intent(Home.this,Review_Invites.class);

        startActivity(intent);
    }

//    @OnClick(R.id.home_button_allleaders)
//    public void allleaders()
//    {
//        startActivity(new Intent(Home.this,Leader_board.class));
//    }
}
