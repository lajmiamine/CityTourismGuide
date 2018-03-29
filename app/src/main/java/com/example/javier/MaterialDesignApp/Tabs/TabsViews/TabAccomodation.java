package com.example.javier.MaterialDesignApp.Tabs.TabsViews;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.javier.MaterialDesignApp.DetailActivity;
import com.example.javier.MaterialDesignApp.R;
import com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewAdapters.AccomodationAdapter;
import com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewClasses.Accomodation;
import com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewDecorations.DividerItemDecoration;
import com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewUtils.ItemClickSupport;
import com.example.javier.MaterialDesignApp.Tabs.TabsUtils.SlidingTabLayout;
import com.example.javier.MaterialDesignApp.Utils.JsonParser;
import com.example.javier.MaterialDesignApp.Utils.ScrollManagerToolbarTabs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class TabAccomodation extends Fragment {

    String urlPost;
    JSONObject jsonObjectDesignPosts;
    JSONArray jsonArrayDesignContent;
    ArrayList<Accomodation> accomodations;
    SwipeRefreshLayout swipeRefreshLayout;
    String[]  accomodationCity, accomodationLink, accomodationHotelName, accomodationWebsite,
                accomodationAvailability,accomodationLongitude,accomodationLat, accomodationContact,
                accomodationId, accomodationAddress;
    int postNumber = 99;
    Boolean error = false;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    View view;
    SharedPreferences sharedPreferences;
    Toolbar toolbar;
    SlidingTabLayout tabs;
    int recyclerViewPaddingTop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.tab_design, container, false);

        // Get shared preferences
        sharedPreferences = getActivity().getSharedPreferences("VALUES", Context.MODE_PRIVATE);

        // Setup RecyclerView News
        recyclerViewDesign(view);

        // Setup swipe to refresh
        swipeToRefresh(view);

        return view;
    }

    private void recyclerViewDesign(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewDesign);
        tabs = (SlidingTabLayout) view.findViewById(R.id.tabs);

        // Divider
        recyclerView.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(android.R.drawable.divider_horizontal_bright)));

        // improve performance if you know that changes in content
        // do not change the size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        urlPost = "http://192.168.1.98/accommodation/sfax";

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        new AsyncTaskNewsParseJson().execute(urlPost);

        ItemClickSupport itemClickSupport = ItemClickSupport.addTo(recyclerView);
        itemClickSupport.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position, long id) {
                sharedPreferences.edit().putString("CITY", accomodationCity[position]).apply();
                sharedPreferences.edit().putString("LINK", accomodationLink[position]).apply();
                sharedPreferences.edit().putString("HOTELNAME", accomodationHotelName[position]).apply();
                sharedPreferences.edit().putString("WEBSITE", accomodationWebsite[position]).apply();
                sharedPreferences.edit().putString("Availability",  accomodationAvailability[position]).apply();
                sharedPreferences.edit().putString("LONG", accomodationLongitude[position]).apply();
                sharedPreferences.edit().putString("LAT", accomodationLat[position]).apply();
                sharedPreferences.edit().putString("CONTACT", accomodationContact[position]).apply();
                sharedPreferences.edit().putString("ID", accomodationId[position]).apply();
                sharedPreferences.edit().putString("ID", accomodationAddress[position]).apply();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });

    }

    public class AsyncTaskNewsParseJson extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
        }

        // get JSON Object
        @Override
        protected String doInBackground(String... url) {

            urlPost = url[0];
            try {
                jsonObjectDesignPosts = JsonParser.readJsonFromUrl(urlPost);
                postNumber = jsonObjectDesignPosts.getJSONArray("accommodation").length();
                jsonArrayDesignContent = jsonObjectDesignPosts.getJSONArray("accommodation");
                sharedPreferences.edit().putString("ACCOMMODATION", jsonArrayDesignContent.toString()).apply();
                accomodationAvailability = new String[postNumber];
                accomodationCity = new String[postNumber];
                accomodationContact= new String[postNumber];
                accomodationHotelName= new String[postNumber];
                accomodationId= new String[postNumber];
                accomodationLat= new String[postNumber];
                accomodationLink= new String[postNumber];
                accomodationLongitude= new String[postNumber];
                accomodationWebsite= new String[postNumber];
                accomodationAddress=new String[postNumber];
                for (int i = 0; i < postNumber; i++) {
                    accomodationWebsite[i] = jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getString("website").toString();
                    Log.v("website",accomodationWebsite[i]);
                    accomodationAddress[i]=jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getString("address").toString();
                    accomodationLongitude[i] = jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getJSONObject("location").getString("long").toString();
                    accomodationLat[i] = jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getJSONObject("location").getString("lat").toString();
                    accomodationLink[i] = jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getString("link").toString();
                    accomodationAvailability[i] = jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getString("availability").toString();

                    accomodationCity[i] = jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getString("city").toString();
                    accomodationHotelName[i] = jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getString("name").toString();
                    accomodationId[i] = jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getString("id").toString();
                    accomodationContact[i] = jsonObjectDesignPosts.getJSONArray("accommodation").getJSONObject(i).getString("contact").toString();
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                accomodationCity = new String[0];
                error = true;
            }
            return null;
        }

        // Set facebook items to the textviews and imageviews
        @Override
        protected void onPostExecute(String result) {

            accomodations= new ArrayList<>();

            //Data set used by the recyclerViewAdapter. This data will be displayed.
            if (accomodationCity.length != 0) {
                for (int i = postNumber - 1; i >= 0; i--) {
                    accomodations.add(new Accomodation( accomodationAddress[i],accomodationCity[i], accomodationLink[i],accomodationHotelName[i],accomodationWebsite[i],accomodationAvailability[i],accomodationLongitude[i],accomodationLat[i],accomodationContact[i],accomodationId[i]));
                }
            }
            if (error) {
                Toast.makeText(getActivity(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
            // Create the recyclerViewAdapter
            recyclerViewAdapter = new AccomodationAdapter(getActivity(), accomodations);
            recyclerView.setAdapter(recyclerViewAdapter);

            swipeRefreshLayout = (android.support.v4.widget.SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
            swipeRefreshLayout.setRefreshing(false);

            // Create the recyclerViewAdapter
            recyclerViewAdapter = new AccomodationAdapter(getActivity(), accomodations);
            recyclerView.setAdapter(recyclerViewAdapter);

            swipeRefreshLayout = (android.support.v4.widget.SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
            swipeRefreshLayout.setRefreshing(false);

            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.GONE);
        }
    }

    private void swipeToRefresh(View view) {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        int start = recyclerViewPaddingTop - convertToPx(48), end = recyclerViewPaddingTop + convertToPx(16);
        swipeRefreshLayout.setProgressViewOffset(true, start, end);
        TypedValue typedValueColorPrimary = new TypedValue();
        TypedValue typedValueColorAccent = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.colorPrimary, typedValueColorPrimary, true);
        getActivity().getTheme().resolveAttribute(R.attr.colorAccent, typedValueColorAccent, true);
        final int colorPrimary = typedValueColorPrimary.data, colorAccent = typedValueColorAccent.data;
        swipeRefreshLayout.setColorSchemeColors(colorPrimary, colorAccent);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTaskNewsParseJson().execute(urlPost);
            }
        });
    }

    public int convertToPx(int dp) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dp * scale + 0.5f);
    }

    public void toolbarHideShow() {
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.post(new Runnable() {
            @Override
            public void run() {
                ScrollManagerToolbarTabs manager = new ScrollManagerToolbarTabs(getActivity());
                manager.attach(recyclerView);
                manager.addView(toolbar, ScrollManagerToolbarTabs.Direction.UP);
                manager.setInitialOffset(toolbar.getHeight());
            }
        });
    }
}

