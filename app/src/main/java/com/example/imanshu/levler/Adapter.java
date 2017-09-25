package com.example.imanshu.levler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.imanshu.levler.views.RoundedImageView;

import java.util.List;

/**
 * Created by Imanshu on 6/26/2017.
 */

public class Adapter extends BaseAdapter {

    Context context;
    List<Getter_Setter> getterSetters;


    public Adapter(Context context, List<Getter_Setter> getterSetters) {
        this.context = context;
        this.getterSetters = getterSetters;
    }

    @Override
    public int getCount() {
        return getterSetters.size();
    }

    @Override
    public Object getItem(int position) {
        return getterSetters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=View.inflate(context,R.layout.inflate_myreview,null);
        ReadMoreTextView myreviews_review=(ReadMoreTextView)v.findViewById(R.id.myreviews_review);
        RoundedImageView myreview_rounded_view=(RoundedImageView)v.findViewById(R.id.myreview_rounded_view);
        TextView myreview_name=(TextView)v.findViewById(R.id.myreview_name);
        TextView myreview_phone=(TextView)v.findViewById(R.id.myreview_phone);
       RatingBar myreview_ratingbar=(RatingBar)v.findViewById(R.id.myreview_ratingbar);
     TextView status=(TextView)v.findViewById(R.id.status);

        myreview_rounded_view.setImageResource(getterSetters.get(position).getImages());
        myreview_name.setText(getterSetters.get(position).getPlayers());
        myreview_phone.setText(getterSetters.get(position).getPhone());
        myreviews_review.setText(getterSetters.get(position).getReviews());
       myreview_ratingbar.setRating(getterSetters.get(position).getRating());
        status.setText(getterSetters.get(position).getStatus());

        for (int i=0;i<=getterSetters.size();i++)
        {
            if (getterSetters.get(position).getStatus()!="done")
            {
                myreviews_review.setVisibility(View.GONE);
                status.setVisibility(View.VISIBLE);
                myreview_ratingbar.setVisibility(View.GONE);
                myreview_rounded_view.setImageResource(R.drawable.pending);
            }
            if (getterSetters.get(position).getStatus()==null)
            {
                myreviews_review.setVisibility(View.GONE);
               status.setVisibility(View.VISIBLE);
                status.setText("Not Sent");
                myreview_ratingbar.setVisibility(View.GONE);
                myreview_rounded_view.setImageResource(R.drawable.not_sent);
            }
//            else{
//                myreviews_review.setVisibility(View.VISIBLE);
//                status.setVisibility(View.GONE);
//            }
        }


        return v;
    }
}
