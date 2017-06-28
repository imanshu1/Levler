package com.example.imanshu.levler;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class My_Invites_Review extends Fragment {

    ListView myreviews_list;
    Adapter adapter1;
    List<Getter_Setter> getterSetters;



    String[] players = {"Vijay", "Prashant","Arun", "Dummy",  "Imanshu", "Nikhil"};

    Float[] getRating={Float.valueOf(3),Float.valueOf(4),Float.valueOf(2),Float.valueOf(1), Float.valueOf(2),Float.valueOf(3)};

    int[] images = {R.drawable.fb_logo, R.drawable.fb_logo, R.drawable.fb_logo, R.drawable.fb_logo, R.drawable.fb_logo, R.drawable.fb_logo};
    String[] phone={"1234567890","9876543210","1598745632","1569874563","4563217890","8521479630"};

    //String[] stat={null,"Invite Sent",null,null,null,null};

    String[] reviews={"hii this is just a review for testing purpose please dont take it seriously",
            null,
            "hii this is just a review for testing purpose please dont take it seriously",
            "hii this is just a review for testing purpose please dont take it seriously",
            "hii this is just a review for testing purpose please dont take it seriously",
            "hii this is just a review for testing purpose please dont take it seriously"};

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    int i = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_my__invites__review, container, false);


        myreviews_list=(ListView)view.findViewById(R.id.my_invites_list);
        getterSetters=new ArrayList<>();

        getterSetters.add(new Getter_Setter("Vijay",R.drawable.fb_logo,"9729118017","this is just for testing purpose","done",Float.valueOf(3)));
        getterSetters.add(new Getter_Setter("Imanshu",R.drawable.fb_logo,"9729118017","this is just for testing purpose","Pending",Float.valueOf(5)));
        getterSetters.add(new Getter_Setter("Nikhil",R.drawable.fb_logo,"9729118017","this is just for testing purpose","done",Float.valueOf(4)));
        getterSetters.add(new Getter_Setter("Arun",R.drawable.fb_logo,"9729118017","this is just for testing purpose","done",Float.valueOf(2)));

//        for (i=0;i<=getRating.length;i++)
//        {
//          if (getterSetters.get(i).getStatus()!="done")
//          {
//              ReadMoreTextView my=(ReadMoreTextView).findViewById(R.id.myreviews_review);
//              my.setVisibility(View.GONE);
//
//          }
//        }

        adapter1=new Adapter(getActivity(),getterSetters);
        myreviews_list.setAdapter(adapter1);

        /////////////////////////////////////////////////////////////////
//        HashMap<String, String> map = new HashMap<String, String>();
//
//
//        for (i = 0; i < players.length; i++) {
//            map = new HashMap<String, String>();
//            map.put("Rating", String.valueOf(getRating[i]));
//            map.put("Reviews", reviews[i]);
//            if(reviews[i]!=null)
//            {
//                map.put("Status",null);
//            }
//            else{
//                map.put("Status","Invite Sent");
//            }
//            map.put("PlayerA", players[i]);
//
//            map.put("Phone", phone[i]);
//            map.put("ImageA", Integer.toString(images[i]));
//            data.add(map);
//        }
//
//        String[] from = {"PlayerA","Status","Rating","Reviews","Phone", "ImageA"};
//
////        for (i=0;i<=reviews.length;i++)
////        {
////            if (reviews[i]==null){
////                TextView tt = (TextView)getActivity().findViewById(R.id.status);
////                tt.setVisibility(VISIBLE);
////            }
//////            else{
//////                ReadMoreTextView tt = (ReadMoreTextView) getActivity().findViewById(R.id.myreviews_review);
//////                tt.setVisibility(View.GONE);
//////            }
////        }
//
//
//        int[] to = {R.id.myreview_name,R.id.status,R.id.myreview_ratingbar,R.id.myreviews_review, R.id.myreview_phone,R.id.myreview_rounded_view};
//
////        if (from[3]==null) {
////            ReadMoreTextView tt = (ReadMoreTextView) getActivity().findViewById(R.id.myreviews_review);
////           // TextView st=(TextView)getActivity().findViewById(R.id.myreview_status);
////           // st.setVisibility(View.VISIBLE);
////            tt.setVisibility(View.GONE);
////            setEmptyText("Your empty text");
////
////        }
//
//
//        adapter = new SimpleAdapter(getActivity(), data, R.layout.inflate_myreview, from, to);
//        adapter.setViewBinder(new MyBinder());
//        setListAdapter(adapter);

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Inflate the layout for this fragment
        return view;
    }

}