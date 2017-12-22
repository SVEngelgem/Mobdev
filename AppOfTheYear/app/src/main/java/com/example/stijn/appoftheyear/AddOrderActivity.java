package com.example.stijn.appoftheyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class AddOrderActivity extends AppCompatActivity{

    AddOrderAdapterActivity adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);


        //absoluut naar deze link kijken
        //https://stackoverflow.com/questions/40587168/simple-android-grid-example-using-recyclerview-with-gridlayoutmanager-like-the


        // data to populate the RecyclerView with
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.add_order_grid);
        int numberOfColumns = 6;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new AddOrderAdapterActivity(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }
}
