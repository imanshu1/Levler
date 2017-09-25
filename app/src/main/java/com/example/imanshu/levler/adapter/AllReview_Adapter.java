package com.example.imanshu.levler.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.imanshu.levler.R;
import com.example.imanshu.levler.pojo.Message;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imanshu on 9/20/2017.
 */

public class AllReview_Adapter extends BaseAdapter{

    Activity activity;
    List<Message> responseList;

    public AllReview_Adapter(Activity activity, List<Message> responseList) {

        this.activity = activity;
        this.responseList = responseList;
    }

    public void addList(ArrayList<Message> list)
    {
        this.responseList = list;
        notifyDataSetChanged();
        //it notify adapter  notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return responseList.size();
    }

    @Override
    public Object getItem(int position) {
        return responseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=View.inflate(activity, R.layout.inflate_myreview,null);
        TextView myreview_name=(TextView)v.findViewById(R.id.myreview_name);
        RatingBar myreview_ratingbar=(RatingBar) v.findViewById(R.id.myreview_ratingbar);
        ImageView myreview_rounded_view=(ImageView)v.findViewById(R.id.myreview_rounded_view);
        ReadMoreTextView myreviews_review=(ReadMoreTextView)v.findViewById(R.id.myreviews_review);
        TextView myreviews_review_Text=(TextView)v.findViewById(R.id.myreviews_review_Text);

        if (responseList.get(position).getComment().length()>50 ){
            myreviews_review.setVisibility(View.VISIBLE);
            myreviews_review.setText(responseList.get(position).getComment());
            myreviews_review_Text.setVisibility(View.GONE);
        }
        else {
            myreviews_review_Text.setVisibility(View.VISIBLE);
            myreviews_review_Text.setText(" "+responseList.get(position).getComment());
            myreviews_review.setVisibility(View.GONE);
        }


        Picasso.with(activity).load(responseList.get(position).getSrc()).into(myreview_rounded_view);

        myreview_name.setText(responseList.get(position).getName());
        myreviews_review.setText(responseList.get(position).getComment());
        myreview_ratingbar.setRating(responseList.get(position).getRating());


        return v;
    }
}
