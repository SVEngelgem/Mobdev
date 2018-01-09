package com.example.stijn.appoftheyear;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import io.realm.Realm;

/**
 * Created by stijn on 29/11/2017.
 */

public class BeverageListArrayAdapter extends ArrayAdapter<Consumptie>{
    public BeverageListArrayAdapter(Context context, List<Consumptie> consumptieList){super(context,-1,consumptieList);}
    Realm realm = Realm.getDefaultInstance();

    public View getView(final int position, View convertView, ViewGroup parent){
        final Consumptie consumptie = getItem(position);
        final String nameconsumptie = consumptie.getName();
        final Double priceconsumptie = consumptie.getPrice();
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_beverage_list_item,null);

        final TextView naam = (TextView) view.findViewById(R.id.beverage_list_item_name);
        naam.setText(""+nameconsumptie);

        TextView price = (TextView) view.findViewById(R.id.beverage_list_item_price);
        price.setText(""+priceconsumptie);

        Button removeItem = (Button) view.findViewById(R.id.beverage_list_item_button_remove);
        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Button wilt "+position+ " verwijderen",Toast.LENGTH_SHORT).show();
                realm.beginTransaction();
                consumptie.deleteFromRealm();
                realm.commitTransaction();
                notifyDataSetChanged();


            }
        });

        Button modifyItem = (Button) view.findViewById(R.id.beverage_list_item_button_modify);
        modifyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder addBeerBuilder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mainView = inflater.inflate(R.layout.dialog_modifybeer, null);

                //de mainview hier is nodig om te reffereren naar de juiste View waar we in bezigzijn, niet de beverage listactivity maar de AlertDialog.
                final EditText addName = (EditText) mainView.findViewById(R.id.beverage_add_button_name);
                final EditText addPrice = (EditText) mainView.findViewById(R.id.beverage_add_button_price);
                final Button addBeerButton = (Button) mainView.findViewById(R.id.beverage_add_button_button);
                final TextView addTitle = (TextView) mainView.findViewById(R.id.beverage_add_title);

                //maakt alertDialog aan om later mee te kunnen werken
                addBeerBuilder.setView(mainView);
                final AlertDialog dialog = addBeerBuilder.create();
                addBeerButton.setText(R.string.changebeer);
                addTitle.setText(R.string.changebeer);
                if(nameconsumptie != null){
                    addName.setText(nameconsumptie);
                }
                if(priceconsumptie != null){
                    addPrice.setText(""+priceconsumptie);
                }

                addBeerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!addName.getText().toString().isEmpty()&&!addPrice.getText().toString().isEmpty()){
                            //omzetten waardes naar bruikbare values (als ze niet null blijken te zijn)
                            final String newName = addName.getText().toString();
                            final double newPrice = Double.parseDouble(addPrice.getText().toString());
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    consumptie.setName(newName);
                                    consumptie.setPrice(newPrice);
                                }
                            });
                            dialog.dismiss();

                        }else{
                            Toast.makeText(getContext(),"invalid input",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
            }
        });

        return view;
    }
}

