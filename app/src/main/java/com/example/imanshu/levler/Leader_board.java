package com.example.imanshu.levler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;

public class Leader_board extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        ButterKnife.bind(this);


        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        pager.setCurrentItem(1);

////////////////////////////////////toolbar////////////////////////////////////
        Toolbar toolbar = (Toolbar) findViewById(R.id.leaderboard_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Leader Board");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


////////////////////////////////////////////////////////////////////////////////////

    }
/////////////////////////////////////////////////////////////fragment//////////////////////////////////////////
    public static class PlaceholderFragment extends ListFragment {



        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();



            ;




            // Bundle args = new Bundle();
           // args.putInt(ARG_SECTION_NUMBER, sectionNumber);
           // fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.inflator_leader_board, container, false);



            String[] players = {"arun", "dummy", "vijay", "prashant", "Imanshu", "nikhil"};
            int[] images = {R.drawable.image_user, R.drawable.image_user, R.drawable.image_user, R.drawable.image_user, R.drawable.image_user, R.drawable.image_user};

            ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
            SimpleAdapter adapter;

            int i = 0;

            HashMap<String, String> map = new HashMap<String, String>();
            ArrayList<Bundle> args1=new ArrayList<Bundle>();



            Bundle bn=new Bundle();
            for (i = 0; i < players.length; i++) {
                map = new HashMap<String, String>();
                map.put("PlayerA", players[i]);
                map.put("CountA", Integer.toString(i + 1));
                map.put("ImageA", Integer.toString(images[i]));
                data.add(map);
                HashMap<String, String> map1 = data.get(i);
                bn.putSerializable("HASHMAP", data);




//                for (Map.Entry<String, String> entry : map.entrySet()) {
//
//
//                        TextView textView = (TextView) rootView.findViewById(R.id.name_infl_las);
//                        textView.setText(players[i]);
//
//                   // Toast.makeText(getActivity()," : "+entry.getValue(), Toast.LENGTH_SHORT).show();
//
//                    // System.out.println(entry.getKey()+" : "+entry.getValue());
//                }

            }
            bn.getSerializable("HASHMAP");

            String[] from = {"PlayerA", "CountA", "ImageA"};
            int[] to = {R.id.name_infl_all, R.id.rank_infl_all, R.id.img_infl_all};
            adapter = new SimpleAdapter(getActivity(), data, R.layout.fragment_all_time, from, to);
            setListAdapter(adapter);

            return super.onCreateView(inflater, container, savedInstanceState);

//            TextView textView = (TextView) rootView.findViewById(R.id.name_infl_las);
//            textView.setText();
            //return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {




        final int PAGE_COUNT = 3;

        private String tabtitles[] = new String[] { "This Month", "Last Month", "All-Time" };
        Context context;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);

            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
           // return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabtitles[position];
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////



}
