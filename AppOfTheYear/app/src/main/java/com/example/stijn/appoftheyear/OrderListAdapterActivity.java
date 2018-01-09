package com.example.stijn.appoftheyear;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import io.realm.ObjectChangeSet;
import io.realm.Realm;
import io.realm.RealmObjectChangeListener;
import io.realm.RealmResults;

/**
 * Created by stijn on 20/12/2017.
 */

public class OrderListAdapterActivity extends ArrayAdapter<Order>{
    public OrderListAdapterActivity(Context context, List<Order> orderList){super(context, -1, orderList);}
    Realm realm = Realm.getDefaultInstance();


    public View getView(final int position, View convertView, ViewGroup parent){
        final Order order = getItem(position);
        final String name = order.getName();
        final Double price = order.getTotalprice();
        final int positionVisual = position+1;
        final boolean payed = order.isPayed();

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_order_list_item,null);

        TextView naam = (TextView) view.findViewById(R.id.order_list_item_name);
        TextView prijs = (TextView) view.findViewById(R.id.order_list_item_price);
        TextView ordernumber = (TextView) view.findViewById(R.id.order_list_item_number);
        final Button buttonPayed = (Button)view.findViewById(R.id.order_list_item_payed);
        final Button buttonOverview = (Button)view.findViewById(R.id.order_list_item_overview);
        final Button buttonRemove = (Button)view.findViewById(R.id.order_list_item_remove);
        LinearLayout layout = (LinearLayout)view.findViewById(R.id.order_list_item_totaal);

        naam.setText("name: "+name);
        prijs.setText("Bill: "+new DecimalFormat("##.##").format(price));
        ordernumber.setText("#"+positionVisual);



        buttonPayed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    buttonPayed.setText(R.string.payed);
                    buttonPayed.setBackgroundResource(R.color.payed);

            }
        });
        buttonOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), OrderViewActivity.class);
                i.putExtra("pos", position);
                getContext().startActivity(i);

            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                order.deleteFromRealm();
                realm.commitTransaction();
                notifyDataSetChanged();

            }
        });

        return view;
    }

}
