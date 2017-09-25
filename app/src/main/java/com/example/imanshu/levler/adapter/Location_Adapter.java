package com.example.imanshu.levler.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.imanshu.levler.R;
import com.example.imanshu.levler.pojo.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imanshu on 8/28/2017.
 */

public class Location_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Location> arrayList;
    Activity context;

    public Location_Adapter(List<Location> arrayList, Activity context) {
        super();
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_location, parent, false);
        return new ComplaintsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ComplaintsViewHolder)
        {
            ComplaintsViewHolder complaintsViewHolder=(ComplaintsViewHolder)holder;

            String s=arrayList.get(position).getName();
            complaintsViewHolder.heading.setText(s);
            Log.i("adapterPlace",""+arrayList);
        }

    }

    public void addList(ArrayList<Location> list)
    {
        this.arrayList = list;
        notifyDataSetChanged();
        //it notify adapter  notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ComplaintsViewHolder extends RecyclerView.ViewHolder{

        public TextView heading;

        public ComplaintsViewHolder(final View itemView) {
            super(itemView);

            heading=(TextView)itemView.findViewById(R.id.heading);

        }
    }
}
