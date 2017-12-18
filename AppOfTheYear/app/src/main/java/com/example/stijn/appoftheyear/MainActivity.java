package com.example.stijn.appoftheyear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantieren waar realm nodig is.
        //Realm realm = Realm.getDefaultInstance();

        //naar nieuwe dag orderlijst
        final Button totalOrderListActivityView = (Button)findViewById(R.id.buttonNewDay);
        totalOrderListActivityView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, TotalOrderListActivity.class);
                startActivity(i);
            }
        });


        //naar draklijst gaan
        final Button beverageListActivityView = (Button)findViewById(R.id.buttoneditList);
        beverageListActivityView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, BeverageListActivity.class);
                startActivity(i);
            }
        });

        //naar orderlijst gaan
        /*voor classe te implementren is het nodig om single table inheritance te implementeren
        enkele bronnen hiervoor:
        http://www.techburps.com/jpa/jpa-inheritance-strategy-table-per-hierarchy/47/
        http://www.thejavageek.com/2014/05/14/jpa-single-table-inheritance-example/
        */


        //test versie met de hond klasse.
        /*Hond hond = new Hond("man", "terrier");
        realm.beginTransaction();
        realm.copyToRealm(hond);
        realm.commitTransaction();

        final RealmResults<Hond> honden = realm.where(Hond.class).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //delete alles
                honden.deleteAllFromRealm();
                //verweider alles van realm
                //honden.deleteFirstFromRealm();
                //honden.deleteLastFromRealm();
                //verwijder specifiek object
                //Hond hond = honden.get(2);
                //hond.deleteFromRealm();
            }
        });*/
        /*for (Hond hondget : honden) {
            System.out.println(hondget.geslacht+hondget.soort);
        }*/

        /*Consumptie consumptie = new Consumptie("jupiler",1.7);
        realm.beginTransaction();
        realm.copyToRealm(consumptie);
        realm.commitTransaction();

        final RealmResults<Consumptie> consumpties = realm.where(Consumptie.class).findAll();
        for (Consumptie consumptie1 : consumpties){
            System.out.println(consumptie1.getPrice()+consumptie1.getName());
        }*/
    }
}
