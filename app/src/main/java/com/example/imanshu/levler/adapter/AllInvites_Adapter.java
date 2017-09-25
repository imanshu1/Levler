package com.example.imanshu.levler.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.imanshu.levler.R;
import com.example.imanshu.levler.pojo.Datum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imanshu on 8/30/2017.
 */

public class AllInvites_Adapter extends BaseAdapter {

    Activity activity;
    List<Datum> datumList;

    public AllInvites_Adapter(Activity activity, List<Datum> datumList) {
        this.activity = activity;
        this.datumList = datumList;
    }


    public void addList(ArrayList<Datum> list)
    {
        this.datumList = list;
        notifyDataSetChanged();
        //it notify adapter  notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return datumList.size();
    }

    @Override
    public Object getItem(int position) {
        return datumList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=View.inflate(activity, R.layout.allinvites_inflate,null);
        TextView name_invites=(TextView)v.findViewById(R.id.name_invites);
        TextView phone_invites=(TextView)v.findViewById(R.id.phone_invites);
        TextView time_invites=(TextView)v.findViewById(R.id.time_invites);
        TextView count_invites=(TextView)v.findViewById(R.id.count_invites);

        String date = datumList.get(position).getCreatedAt().substring(0, 10);

        name_invites.setText(datumList.get(position).getName());
        phone_invites.setText(datumList.get(position).getPhone());
        time_invites.setText(date);
        count_invites.setText((position+1)+".");


        return v;
    }
}
