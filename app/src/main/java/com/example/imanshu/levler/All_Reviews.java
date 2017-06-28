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


public class All_Reviews extends Fragment {


    ListView allreviews_list;
    Adapter adapter1;
    List<Getter_Setter> getterSetters;

    String[] players = {"Frank", "Alice", "Bart", "Jeanette", "Rachel", "John"};
    int[] images = {R.drawable.download, R.drawable.fb_logo, R.drawable.fb_logo, R.drawable.fb_logo, R.drawable.fb_logo, R.drawable.fb_logo};

    String[] phone={"801-555-1234","987-654-3210","159-874-5632","156-987-4563","456-321-7890","852-147-9630"};

    Float[] getRating={Float.valueOf(3),Float.valueOf(4),Float.valueOf(2),Float.valueOf(1), Float.valueOf(2),Float.valueOf(3)};

    String[] reviews={"hii this is just a review for testing purpose please dont take it seriously",
            "hii this is just a review for testing purpose please dont take it seriously.hii this is just a review for testing purpose please dont take it seriously.hii this is just a review for testing purpose please dont take it seriously",
            "hii this is just a review for testing purpose please dont take it seriously",
            "hii this is just a review for testing purpose please dont take it seriously",
            "hii this is just a review for testing purpose please dont take it seriously",
            "hii this is just a review for testing purpose please dont take it seriously"};

   // Float[] rating={1.0f,2.0f,3.0f,5.2f,2.1f,1.0f};

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    int i = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view =inflater.inflate(R.layout.fragment_all__reviews, container, false);


        allreviews_list=(ListView)view.findViewById(R.id.allreviews_list);
        getterSetters=new ArrayList<>();

        getterSetters.add(new Getter_Setter("Arun",R.drawable.fb_logo,"9729118017","this is just for testing purpose",null,Float.valueOf(3)));
        getterSetters.add(new Getter_Setter("vijay",R.drawable.fb_logo,"9729118017","this is just for testing purpose","Pending",Float.valueOf(5)));
        getterSetters.add(new Getter_Setter("Nikhil",R.drawable.fb_logo,"9729118017","this is just for testing purpose,this is just for testing purpos,this is just for testing purpos","done",Float.valueOf(4)));
        getterSetters.add(new Getter_Setter("Imanshu",R.drawable.fb_logo,"9729118017","this is just for testing purpose","done",Float.valueOf(2)));

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
        allreviews_list.setAdapter(adapter1);

        return view;





////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//        HashMap<String, String> map = new HashMap<String, String>();
//
//
//        for (i = 0; i < players.length; i++) {
//            map = new HashMap<String, String>();
//            map.put("PlayerA", players[i]);
//            map.put("Rating", String.valueOf(getRating[i]));
//            map.put("Reviews", reviews[i]);
//            map.put("Phone", phone[i]);
//            map.put("ImageA", Integer.toString(images[i]));
//            data.add(map);
//        }
//
//        String[] from = {"PlayerA","Rating","Reviews","Phone", "ImageA"};
//        int[] to = {R.id.myreview_name,R.id.myreview_ratingbar,R.id.myreviews_review, R.id.myreview_phone,R.id.myreview_rounded_view};
//        adapter = new SimpleAdapter(getActivity(), data, R.layout.inflate_myreview, from, to);
//        adapter.setViewBinder(new MyBinder());
//        setListAdapter(adapter);
//        // Inflate the layout for this fragment
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
////////////////////////////////////binder.///////////////////////////////////
//class MyBinder implements SimpleAdapter.ViewBinder {
//    @Override
//    public boolean setViewValue(View view, Object data, String textRepresentation) {
//        if(view.getId() == R.id.myreview_ratingbar){
//            String stringval = (String) data;
//            float ratingValue = Float.parseFloat(stringval);
//            RatingBar ratingBar = (RatingBar) view;
//            ratingBar.setRating(ratingValue);
//            return true;
//        }
//        return false;
//    }
//}
