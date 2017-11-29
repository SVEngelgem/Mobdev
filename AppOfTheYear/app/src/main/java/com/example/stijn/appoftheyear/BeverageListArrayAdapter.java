package com.example.stijn.appoftheyear;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by stijn on 29/11/2017.
 */

public class BeverageListArrayAdapter extends ArrayAdapter<Consumptie>{
    public BeverageListArrayAdapter(Context context, List<Consumptie> consumptieList){super(context,-1,consumptieList);}

    public View getView(int position, View convertView, ViewGroup parent){
        Consumptie consumptie = getItem(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_beverage_list_item,null);

        TextView naam = (TextView) view.findViewById(R.id.beverage_list_item_name);
        naam.setText(""+consumptie.getName());

        TextView price = (TextView) view.findViewById(R.id.beverage_list_item_price);
        price.setText(""+consumptie.getPrice());

        return view;
    }
}
