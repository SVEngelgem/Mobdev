package com.example.stijn.appoftheyear;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.realm.Realm;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;


/**
 * Created by stijn on 21/12/2017.
 */
class AddOrderAdapterActivity extends RealmRecyclerViewAdapter<Consumptie, AddOrderAdapterActivity.MyViewHolder>{

    AddOrderAdapterActivity(OrderedRealmCollection<Consumptie> consumpties){
        super(consumpties, true);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_add_order_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
        final Consumptie consumptiedata = getItem(position);
        final int nummerlocatie = position+1;
        holder.data = consumptiedata;

        final String consumptieName = consumptiedata.getName();
        holder.name.setText(consumptieName);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(),"dit is positie"+nummerlocatie,Toast.LENGTH_LONG).show();
            }
        });

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public Consumptie data;

        MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.add_order_grid_item_name);

        }
    }
}

