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
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.javier.MaterialDesignApp.DetailActivity;
import com.example.javier.MaterialDesignApp.R;
import com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewAdapters.ShoppingAdapter;
import com.example.javier.MaterialDesignApp.RecyclerView.RecyclerViewClasses.Shopping;
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

public class TabShopping extends Fragment {

    String urlPost;
    JSONObject jsonObjectDesignPosts;
    JSONArray jsonArrayDesignContent;
    ArrayList<Shopping> shoppings;
    SwipeRefreshLayout swipeRefreshLayout;
    String[] shoppingName, shoppingDescription, shoppingCity,shoppingAdress,shoppingType, shoppingPhone,shoppingId,shoppingLcationLong,shoppingLocationLat;

    int postNumber = 99;
    Boolean error = false;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    View view;
    SharedPreferences sharedPreferences;
    Toolbar toolbar;
    TypedValue typedValueToolbarHeight = new TypedValue();
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

        urlPost = "http://192.168.1.98/shopping/c/sfax";

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        new AsyncTaskNewsParseJson().execute(urlPost);

        ItemClickSupport itemClickSupport = ItemClickSupport.addTo(recyclerView);
        itemClickSupport.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position, long id) {
                sharedPreferences.edit().putString("NAME", shoppingName[position]).apply();
                sharedPreferences.edit().putString("CITY", shoppingCity[position]).apply();
                sharedPreferences.edit().putString("DESCRIPTION", shoppingDescription[position]).apply();
                sharedPreferences.edit().putString("TYPE", shoppingType[position]).apply();
                sharedPreferences.edit().putString("PHONE", shoppingPhone[position]).apply();
                sharedPreferences.edit().putString("ID", shoppingId[position]).apply();
                sharedPreferences.edit().putString("LONG", shoppingLcationLong[position]).apply();
                sharedPreferences.edit().putString("LAT", shoppingLocationLat[position]).apply();
                sharedPreferences.edit().putString("ADRESS", shoppingAdress[position]).apply();



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
                postNumber = jsonObjectDesignPosts.getJSONArray("shopping").length();
                jsonArrayDesignContent = jsonObjectDesignPosts.getJSONArray("shopping");
                sharedPreferences.edit().putString("SHOPPING", jsonArrayDesignContent.toString()).apply();
                shoppingName = new String[postNumber];
                shoppingDescription = new String[postNumber];
                shoppingCity = new String[postNumber];
                shoppingType = new String[postNumber];
                shoppingId = new String[postNumber];
                shoppingLocationLat= new String[postNumber];
                shoppingLcationLong= new String[postNumber];
                shoppingPhone= new String[postNumber];
                shoppingAdress=new String[postNumber];

                for (int i = 0; i < postNumber; i++) {
                    shoppingName[i] = jsonObjectDesignPosts.getJSONArray("shopping").getJSONObject(i).getString("name").toString();
                    shoppingDescription[i] =jsonObjectDesignPosts.getJSONArray("shopping").getJSONObject(i).getString("description").toString();
                    shoppingCity[i] = jsonObjectDesignPosts.getJSONArray("shopping").getJSONObject(i).getString("city").toString();
                    shoppingType[i] = jsonObjectDesignPosts.getJSONArray("shopping").getJSONObject(i).getString("type").toString();

                    shoppingPhone[i] = jsonObjectDesignPosts.getJSONArray("shopping").getJSONObject(i).getString("phone").toString();
                    shoppingAdress[i] = jsonObjectDesignPosts.getJSONArray("shopping").getJSONObject(i).getString("address").toString();
                    shoppingLcationLong[i] = jsonObjectDesignPosts.getJSONArray("shopping").getJSONObject(i).getJSONObject("location").getString("long").toString();
                    shoppingLocationLat[i] = jsonObjectDesignPosts.getJSONArray("shopping").getJSONObject(i).getJSONObject("location").getString("lat").toString();
                    shoppingId[i] = jsonObjectDesignPosts.getJSONArray("shopping").getJSONObject(i).getString("id").toString();



                }


            } catch (IOException | JSONException e) {
                e.printStackTrace();
                shoppingName = new String[0];
                error = true;
            }
            return null;
        }

        // Set facebook items to the textviews and imageviews
        @Override
        protected void onPostExecute(String result) {

            shoppings = new ArrayList<>();

            //Data set used by the recyclerViewAdapter. This data will be displayed.
            if (shoppingName.length != 0) {
                for (int i = postNumber - 1; i >= 0; i--) {
                    shoppings.add(new Shopping(shoppingName[i], shoppingDescription[i], shoppingCity[i],shoppingAdress[i],shoppingType[i], shoppingPhone[i],shoppingId[i],shoppingLcationLong[i],shoppingLocationLat[i] ));
                }
            }
            if (error) {
                Toast.makeText(getActivity(), "Error connexion", Toast.LENGTH_LONG).show();
            }
            // Create the recyclerViewAdapter
            recyclerViewAdapter = new ShoppingAdapter(getActivity(), shoppings);
            recyclerView.setAdapter(recyclerViewAdapter);

            swipeRefreshLayout = (android.support.v4.widget.SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
            swipeRefreshLayout.setRefreshing(false);

            // Create the recyclerViewAdapter
            recyclerViewAdapter = new ShoppingAdapter(getActivity(), shoppings);
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

