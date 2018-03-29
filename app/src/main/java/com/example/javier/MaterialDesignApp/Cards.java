package com.example.javier.MaterialDesignApp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.example.javier.MaterialDesignApp.Fragments.FragmentDesign;


public class Cards extends ActionBarActivity {

    Button go;
    CardView card_view1,card_view2,card_view3,card_view4,card_view5,card_view6,card_view7,card_view8,card_view9,card_view10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        go = (Button) findViewById(R.id.goButton);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Cards.this, MainActivity.class);
                Cards.this.startActivity(myIntent);
            }
        });

        card_view1 = (CardView) findViewById(R.id.card_view1);
        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_view1.setBackgroundColor(Color.GRAY);
                FragmentDesign.titles.add("Shopping");
            }
        });

        card_view2 = (CardView) findViewById(R.id.card_view2);
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_view2.setBackgroundColor(Color.GRAY);
                FragmentDesign.titles.add("Accommodation");
            }
        });

        card_view3 = (CardView) findViewById(R.id.card_view3);
        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_view3.setBackgroundColor(Color.GRAY);
                FragmentDesign.titles.add("Car Rental");
            }
        });

        card_view4 = (CardView) findViewById(R.id.card_view4);
        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_view4.setBackgroundColor(Color.GRAY);
                FragmentDesign.titles.add("Gastronomy");
            }
        });

        card_view5 = (CardView) findViewById(R.id.card_view5);
        card_view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_view5.setBackgroundColor(Color.GRAY);
                FragmentDesign.titles.add("Events");
            }
        });

        card_view6 = (CardView) findViewById(R.id.card_view6);
        card_view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_view6.setBackgroundColor(Color.GRAY);
                FragmentDesign.titles.add("Police Station");
            }
        });

        card_view7 = (CardView) findViewById(R.id.card_view7);
        card_view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_view7.setBackgroundColor(Color.GRAY);
                FragmentDesign.titles.add("Post Office");
            }
        });

        card_view8 = (CardView) findViewById(R.id.card_view8);
        card_view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_view8.setBackgroundColor(Color.GRAY);
                FragmentDesign.titles.add("Health Care");
            }
        });

        card_view9 = (CardView) findViewById(R.id.card_view9);
        card_view9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_view9.setBackgroundColor(Color.GRAY);
                FragmentDesign.titles.add("Services");
            }
        });

    }
}
