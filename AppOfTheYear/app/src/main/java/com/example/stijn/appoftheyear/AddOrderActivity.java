package com.example.stijn.appoftheyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmResults;

public class AddOrderActivity extends AppCompatActivity{
    private Realm realm;
    private RecyclerView recyclerView;
    private AddOrderAdapterActivity adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        realm = Realm.getDefaultInstance();
        recyclerView = (RecyclerView) findViewById(R.id.add_order_grid);

        //absoluut naar deze link kijken
        //https://stackoverflow.com/questions/40587168/simple-android-grid-example-using-recyclerview-with-gridlayoutmanager-like-the
        //krijg voorbeeld van link maar niet clickable

        //andere mogelijkheid
        //http://abhiandroid.com/materialdesign/recyclerview-gridview.html

        SetupRecyclerView();

    }
    private void SetupRecyclerView(){
        adapter = new AddOrderAdapterActivity(realm.where(Consumptie.class).findAll());
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setAdapter(adapter);
    }
}
