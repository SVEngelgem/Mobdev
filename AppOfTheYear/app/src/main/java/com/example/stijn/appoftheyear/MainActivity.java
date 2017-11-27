package com.example.stijn.appoftheyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();

        /*voor classe te implementren is het nodig om single table inheritance te implementeren
        enkele bronnen hiervoor:
        http://www.techburps.com/jpa/jpa-inheritance-strategy-table-per-hierarchy/47/
        http://www.thejavageek.com/2014/05/14/jpa-single-table-inheritance-example/
        */


        //Bier bier = new Bier("Stella", 2.0, "Lager", 5.2);
        Hond hond = new Hond("man", "terrier");
        realm.beginTransaction();
        realm.copyToRealm(hond);
        realm.commitTransaction();

        final RealmResults<Hond> honden = realm.where(Hond.class).findAll();
        for (Hond hondget : honden) {
            System.out.println(hondget.geslacht);
        }
    }
}
