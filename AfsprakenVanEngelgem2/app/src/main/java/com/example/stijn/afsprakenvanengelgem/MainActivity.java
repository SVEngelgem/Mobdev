package com.example.stijn.afsprakenvanengelgem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //de nieuw repository is leeg, de volle uit appointmentDummyRepository moet opgehaalt worden
        //werkt nu
        final List<Appointment> arrayofappointments = new AppointmentDummyRepository().getAppointments();

        //header opmaak
        final Appointment appointment = arrayofappointments.get(0);
        TextView header = (TextView)findViewById(R.id.main_header);
        header.setText("You're next appointment is with "+appointment.getContactName()+" at "+appointment.getDay()+"/"+appointment.getMonth()+" "+appointment.getHour()+":"+appointment.getMinute());

        ListView appointmentListView = (ListView)findViewById(R.id.afspraak_list_view);
        appointmentListView.setAdapter(new AppointmentArrayAdapter(this,arrayofappointments));
        appointmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("pos", position);
                startActivity(i);
            }
        });
    }
}
