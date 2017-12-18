package com.example.stijn.appoftheyear;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class BeverageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_list);
        final Realm realm = Realm.getDefaultInstance();

        final RealmResults<Consumptie> consumpties = realm.where(Consumptie.class).findAll();

        ListView beverageListView = (ListView)findViewById(R.id.beverage_list);
        beverageListView.setAdapter(new BeverageListArrayAdapter(this, consumpties));

        Button addBeveragelist = (Button)findViewById(R.id.beverage_add_button);
        addBeveragelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder addBeerBuilder = new AlertDialog.Builder(BeverageListActivity.this);
                View mainView = getLayoutInflater().inflate(R.layout.dialog_modifybeer, null);

                //de mainview hier is nodig om te reffereren naar de juiste View waar we in bezigzijn, niet de beverage listactivity maar de AlertDialog.
                final EditText addName = (EditText) mainView.findViewById(R.id.beverage_add_button_name);
                final EditText addPrice = (EditText) mainView.findViewById(R.id.beverage_add_button_price);
                final Button addBeerButton = (Button) mainView.findViewById(R.id.beverage_add_button_button);
                final TextView addTitle = (TextView) mainView.findViewById(R.id.beverage_add_title);

                //maakt alertDialog aan om later mee te kunnen werken
                addBeerBuilder.setView(mainView);
                final AlertDialog dialog = addBeerBuilder.create();
                addBeerButton.setText(R.string.addbeer);
                addTitle.setText(R.string.addbeer);
                addBeerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!addName.getText().toString().isEmpty()&&!addPrice.getText().toString().isEmpty()){
                            //omzetten waardes naar bruikbare values (als ze niet null blijken te zijn)
                            final String newName = addName.getText().toString();
                            final double newPrice = Double.parseDouble(addPrice.getText().toString());
                            Consumptie consumptie = new Consumptie(newName,newPrice);
                            //toevoegen van dranken voor bestellijst
                            realm.beginTransaction();
                            realm.copyToRealm(consumptie);
                            realm.commitTransaction();
                            dialog.dismiss();

                        }else{
                            Toast.makeText(BeverageListActivity.this,"invalid input",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
            }
        });
    }

}
