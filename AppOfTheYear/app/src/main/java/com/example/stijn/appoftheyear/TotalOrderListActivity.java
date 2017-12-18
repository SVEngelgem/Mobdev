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

public class TotalOrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_order_list);
        final Realm realm = Realm.getDefaultInstance();

        final RealmResults<Order> orders = realm.where(Order.class).findAll();

        ListView orderListView = (ListView)findViewById(R.id.total_order_list);
        orderListView.setAdapter(new TotalOrderListActivityAdapter(this, orders));

        Button addTotalOrderListButton = (Button) findViewById(R.id.total_order_add_button);
        addTotalOrderListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder addOrderBuilder = new AlertDialog.Builder(TotalOrderListActivity.this);
                View mainView = getLayoutInflater().inflate(R.layout.dialog_addorder, null);

                final EditText addName = (EditText) mainView.findViewById(R.id.total_order_dialog_name);
                final EditText addLocation = (EditText) mainView.findViewById(R.id.total_order_dialog_location);
                final Button addOrderButton = (Button) mainView.findViewById(R.id.total_order_dialog_add);
                final TextView addTitle = (TextView) mainView.findViewById(R.id.total_order_dialog_title);

                addOrderBuilder.setView(mainView);
                final AlertDialog dialog = addOrderBuilder.create();
                addOrderButton.setText("add Order");
                addTitle.setText("add Order");
                addOrderButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!addName.getText().toString().isEmpty()&&!addLocation.getText().toString().isEmpty()){
                            final String newName = addName.getText().toString();
                            final String newLocation = addLocation.getText().toString();

                            //bekijken hoe het aantal realmobj dat dit argument bevat bedraagt.
                            final int idTotal = 0;

                            Order order = new Order(newName,newLocation,idTotal);
                            realm.beginTransaction();
                            realm.copyToRealmOrUpdate(order);
                            realm.commitTransaction();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(TotalOrderListActivity.this,"invalid input",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
            }
        });
    }
}
