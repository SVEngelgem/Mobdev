package com.example.stijn.afsprakenvanengelgem;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intentReciever = getIntent();
        int detailValue = intentReciever.getIntExtra("pos",0);


        TextView detail_name =(TextView)findViewById(R.id.detail_Name);
        TextView detail_date =(TextView)findViewById(R.id.detail_time);
        TextView detail_location =(TextView)findViewById(R.id.detail_location);
        TextView detail_reason =(TextView)findViewById(R.id.detail_reason);
        ImageView detail_profilepic = (ImageView)findViewById(R.id.detail_list_picture);


        final List<Appointment> arrayofappointments = new AppointmentDummyRepository().getAppointments();
        final Appointment appointment = arrayofappointments.get(detailValue);

        detail_name.setText(appointment.getContactName());
        detail_date.setText(appointment.getDay()+"/"+appointment.getMonth()+"/"+appointment.getYear()+"  "+appointment.getHour()+":"+appointment.getMinute());
        detail_location.setText(appointment.getLocation());
        detail_reason.setText(appointment.getReason());
        detail_profilepic.setImageResource(appointment.getImg_id());
    }
}
