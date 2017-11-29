package com.example.stijn.appoftheyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class BeverageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_list);
        Realm realm = Realm.getDefaultInstance();

        final RealmResults<Consumptie> consumpties = realm.where(Consumptie.class).findAll();

        ListView beverageListView = (ListView)findViewById(R.id.beverage_list);
        beverageListView.setAdapter(new BeverageListArrayAdapter(this, consumpties));
    }
}
