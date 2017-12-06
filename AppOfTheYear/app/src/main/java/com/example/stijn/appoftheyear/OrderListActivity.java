package com.example.stijn.appoftheyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class OrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        final Realm realm = Realm.getDefaultInstance();

        final RealmResults<Order>orders = realm.where(Order.class).findAll();

        ListView orderListView = (ListView)findViewById(R.id.order_list);
        orderListView.setAdapter(new OrderListArrayAdapter(this,orders));

    }
}
