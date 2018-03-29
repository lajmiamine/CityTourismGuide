package com.example.javier.MaterialDesignApp.Tabs.TabsAdapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.javier.MaterialDesignApp.Fragments.FragmentDesign;
import com.example.javier.MaterialDesignApp.Tabs.TabsViews.TabAccomodation;
import com.example.javier.MaterialDesignApp.Tabs.TabsViews.TabCarRental;
import com.example.javier.MaterialDesignApp.Tabs.TabsViews.TabGastronomy;
import com.example.javier.MaterialDesignApp.Tabs.TabsViews.TabShopping;

import java.util.ArrayList;

public class TabsDesignViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<CharSequence> titles;
    int tabNumber;

    // Constructor
    public TabsDesignViewPagerAdapter (FragmentManager fragmentManager, ArrayList<CharSequence> titles, int tabNumber) {
        super(fragmentManager);

        this.titles = titles;
        this.tabNumber = tabNumber;

    }

    // Return Fragment for each position
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (FragmentDesign.titles.get(0).equals("Shopping")){
                    TabShopping tabShopping = new TabShopping();
                    return  tabShopping;
                }else
                if (FragmentDesign.titles.get(0).equals("Accommodation")){
                    TabAccomodation tabAccomodation = new TabAccomodation();
                    return  tabAccomodation;
                }else
                if (FragmentDesign.titles.get(0).equals("Car Rental")){
                    TabCarRental TabCarRental = new TabCarRental();
                    return  TabCarRental;
                }else
                if (FragmentDesign.titles.get(0).equals("Gastronomy")){
                    TabGastronomy TabGastronomy = new TabGastronomy();
                    return  TabGastronomy;
                }
            case 1:
                if (FragmentDesign.titles.get(1).equals("Shopping")){
                    TabShopping tabShopping = new TabShopping();
                    return  tabShopping;
                }else
                if (FragmentDesign.titles.get(1).equals("Accommodation")){
                    TabAccomodation tabAccomodation = new TabAccomodation();
                    return  tabAccomodation;
                }else
                if (FragmentDesign.titles.get(1).equals("Car Rental")){
                    TabCarRental TabCarRental = new TabCarRental();
                    return  TabCarRental;
                }else
                if (FragmentDesign.titles.get(1).equals("Gastronomy")){
                    TabGastronomy TabGastronomy = new TabGastronomy();
                    return  TabGastronomy;
                }
            case 2:
                if (FragmentDesign.titles.get(2).equals("Shopping")){
                    TabShopping tabShopping = new TabShopping();
                    return  tabShopping;
                }else
                if (FragmentDesign.titles.get(2).equals("Accommodation")){
                    TabAccomodation TabAccomodation = new TabAccomodation();
                    return  TabAccomodation;
                }else
                if (FragmentDesign.titles.get(2).equals("Car Rental")){
                    TabCarRental TabCarRental = new TabCarRental();
                    return  TabCarRental;
                }else
                if (FragmentDesign.titles.get(2).equals("Gastronomy")){
                    TabGastronomy TabGastronomy = new TabGastronomy();
                    return  TabGastronomy;
                }
            case 3:
                if (FragmentDesign.titles.get(3).equals("Shopping")){
                    TabShopping tabShopping = new TabShopping();
                    return  tabShopping;
                }else
                if (FragmentDesign.titles.get(3).equals("Accommodation")){
                    TabAccomodation TabAccomodation = new TabAccomodation();
                    return  TabAccomodation;
                }else
                if (FragmentDesign.titles.get(3).equals("Car Rental")){
                    TabCarRental TabCarRental = new TabCarRental();
                    return  TabCarRental;
                }else
                if (FragmentDesign.titles.get(3).equals("Gastronomy")){
                    TabGastronomy TabGastronomy = new TabGastronomy();
                    return  TabGastronomy;
                }
        }
        return null;
    }

    // Return tab titles for each position

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    // Return tab number.
    @Override
    public int getCount() {
        return tabNumber;
    }
}