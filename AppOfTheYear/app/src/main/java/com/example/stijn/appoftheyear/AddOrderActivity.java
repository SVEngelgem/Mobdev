package com.example.stijn.appoftheyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import io.realm.Realm;
import io.realm.RealmResults;

public class AddOrderActivity extends AppCompatActivity{
    private Realm realm;
    private RecyclerView recyclerView;
    private AddOrderAdapterActivity adapter;
    Order order = new Order();
    Double price = 0.0;
    int addedOrders;
    String orderList ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        realm = Realm.getDefaultInstance();
        recyclerView = (RecyclerView) findViewById(R.id.add_order_grid);



        Button btnClear = (Button)findViewById(R.id.add_order_clear);
        btnClear.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                price = 0.0;
                addedOrders = 0;
                orderList = "";
                UpdateTextView();
            }
        });

        Button btnAccetp =(Button)findViewById(R.id.add_order_accept);
        btnAccetp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText getNameTxt = (EditText)findViewById(R.id.add_order_id);
                final String newname = getNameTxt.getText().toString();
                order.setName(newname);
                order.setTotalItems(addedOrders);
                order.setVisualList(orderList);
                order.setTotalprice(price);
                if(!getNameTxt.getText().toString().isEmpty()|orderList == null) {
                    realm.beginTransaction();
                    realm.copyToRealm(order);
                    realm.commitTransaction();
                    finish();
                }else{
                    Toast.makeText(AddOrderActivity.this,"Ordername or Drinks added",Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView txtPrice = (TextView) findViewById(R.id.add_order_price);
        txtPrice.setText(""+price);

        TextView txtAmount = (TextView) findViewById(R.id.add_order_amount);
        txtAmount.setText(""+addedOrders);

        EditText addName = (EditText) findViewById(R.id.add_order_id);




        //absoluut naar deze link kijken
        //https://stackoverflow.com/questions/40587168/simple-android-grid-example-using-recyclerview-with-gridlayoutmanager-like-the
        //krijg voorbeeld van link maar niet clickable

        //andere mogelijkheid
        //http://abhiandroid.com/materialdesign/recyclerview-gridview.html

        SetupRecyclerView();

    }
    private void SetupRecyclerView(){
        adapter = new AddOrderAdapterActivity(realm.where(Consumptie.class).findAll(), new AddOrderAdapterActivity.OnItemClickListener() {
            @Override
            public void onItemClick(Consumptie consumptie) {
                String nameCurrent = consumptie.getName();
                Double priceCurrent = consumptie.getPrice();
                price = price + priceCurrent;
                addedOrders ++;
                orderList += consumptie.getName()+"\n";


                //Toast.makeText(AddOrderActivity.this, "added"+ orderList, Toast.LENGTH_SHORT).show();
                UpdateTextView();

            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setAdapter(adapter);
    }
    public void UpdateTextView(){
        //redundant, maar dat is wat je doet met een kort tijdschema.
        TextView txtPrice = (TextView) findViewById(R.id.add_order_price);

        txtPrice.setText(""+price);
        txtPrice.setText(new DecimalFormat("##.##").format(price));

        TextView txtAmount = (TextView) findViewById(R.id.add_order_amount);
        txtAmount.setText(""+addedOrders);

        TextView txtNameList = (TextView)findViewById(R.id.add_order_overzichtlijst);
        txtNameList.setText(orderList);
    }
}
