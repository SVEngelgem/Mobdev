package com.example.stijn.appoftheyear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class OrderViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_view);
        final Realm realm = Realm.getDefaultInstance();

        Intent intentReciever = getIntent();
        int detailValue = intentReciever.getIntExtra("pos",0);

        TextView detail_name =(TextView)findViewById(R.id.detail_Name);
        TextView detail_amount =(TextView)findViewById(R.id.detail_amount);
        TextView detail_price =(TextView)findViewById(R.id.detail_Price);
        TextView detail_order =(TextView)findViewById(R.id.detail_order);

        final RealmResults<Order> orders = realm.where(Order.class).findAll();
        final Order order = orders.get(detailValue);

        detail_name.setText(order.getName());
        detail_amount.setText(""+order.getTotalItems());
        detail_price.setText(""+order.getTotalprice());
        detail_order.setText(order.getVisualList());
    }
}
