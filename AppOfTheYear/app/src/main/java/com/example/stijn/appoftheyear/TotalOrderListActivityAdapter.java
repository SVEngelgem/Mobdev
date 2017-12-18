package com.example.stijn.appoftheyear;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import io.realm.Realm;

/**
 * Created by stijn on 18/12/2017.
 */

public class TotalOrderListActivityAdapter extends ArrayAdapter<Order>{
    public TotalOrderListActivityAdapter(Context context, List<Order> orderList){super(context,-1,orderList);}
    Realm realm = Realm.getDefaultInstance();

    public View getView(final int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_total_order_list_item,null);

        




        return view;
    }
}
