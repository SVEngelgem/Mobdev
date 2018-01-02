package com.example.stijn.appoftheyear;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class OrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        final Realm realm = Realm.getDefaultInstance();

        final RealmResults<Order> orders = realm.where(Order.class).findAll();


        ListView orderListView = (ListView)findViewById(R.id.order_list);
        orderListView.setAdapter(new OrderListAdapterActivity(this, orders));

        Button button_add = (Button)findViewById(R.id.order_list_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order = new Order();
                Intent i = new Intent(OrderListActivity.this, AddOrderActivity.class);
                startActivity(i);
            }
        });
    }
}
