package com.example.stijn.appoftheyear;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by stijn on 6/12/2017.
 */

public class OrderListArrayAdapter extends ArrayAdapter<Order>{
    public OrderListArrayAdapter(Context context, List<Order> orderList){super(context,-1,orderList);}
    Realm realm = Realm.getDefaultInstance();

    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_order_list_item,null);

        final Order order = getItem(position);
        final String nameOrderConsumtie = order.getConsumptie().getName();

        final TextView naam = (TextView) view.findViewById(R.id.order_list_item_name);
        naam.setText(""+nameOrderConsumtie);

        Button orderItemAdd = (Button) view.findViewById(R.id.order_list_item_increase);

        Button orderItemRemove = (Button) view.findViewById(R.id.order_list_item_decrease);

        EditText orderItemAmount = (EditText) view.findViewById(R.id.order_list_item_amount);

        return view;
    }
}
