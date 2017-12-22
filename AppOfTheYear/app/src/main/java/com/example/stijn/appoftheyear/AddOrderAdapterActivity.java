package com.example.stijn.appoftheyear;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by stijn on 21/12/2017.
 */

public class AddOrderAdapterActivity extends RecyclerView.Adapter<AddOrderAdapterActivity.ViewHolder> {

    private String[] mData = new String[0];
    private LayoutInflater mInflater;


    //opbouwen van de verschillende lissteners
    //slaagt en recycliert de views als ze van het scherm gaan
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView myTextView;

        public ViewHolder(View itemView){
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.add_order_grid_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            onItemClick(view, getAdapterPosition());
        }
    }
    //data op kliklocatie brengen
    String getItem(int id) {
        return mData[id];
    }

    //constructor
    public AddOrderAdapterActivity(Context context, String[] data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    //inflating van de cell

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.activity_add_order_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //bind de data aan de textview in elke cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        String iets = mData[position];
        holder.myTextView.setText(iets);
    }

    @Override
    public int getItemCount(){
        return mData.length;
    }

    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + getItem(position).toString() + ", which is at cell position " + position);
    }

}
