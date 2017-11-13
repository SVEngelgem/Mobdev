package com.example.stijn.afsprakenvanengelgem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.stijn.afsprakenvanengelgem.AppointmentDummyRepository.getInstance;

/**
 * Created by stijn on 11/11/2017.
 */

/*public class AppointmentArrayAdapter extends ArrayAdapter<IAppointmentsRepository> {

    AppointmentDummyRepository appointmentDummyRepository = new AppointmentDummyRepository();
    List<Appointment> appointments = appointmentDummyRepository.getAppointments();

    public AppointmentArrayAdapter(Context context, IAppointmentsRepository[] arr){ super(context, -1,arr);}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(
                R.layout.afspraak_list_item, null);

        TextView datumView = (TextView)view.findViewById(R.id.);
        datumView.setText();

        return view;
    }
}*/
public class AppointmentArrayAdapter extends ArrayAdapter<Appointment>{

    public AppointmentArrayAdapter(Context context, List<Appointment> appointments){super(context, -1,appointments); }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Appointment appointment = getItem(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(
                //ergens verkeerde aanroeping juiste waarde daardoor verkeerde verwerking waarde
                R.layout.afspraak_list_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.afspraak_list_picture);
        imageView.setImageResource(appointment.getImg_id());

        TextView textView = (TextView) view.findViewById(R.id.afspraak_list_date);
        textView.setText(""+appointment.getDay()+"/"+appointment.getMonth()+"/"+appointment.getYear());


        TextView textView1 = (TextView)view.findViewById(R.id.afspraak_list_hour);
        textView1.setText(""+appointment.getHour()+":"+appointment.getMinute());

        TextView textView2 = (TextView)view.findViewById(R.id.afspraak_list_name);
        textView2.setText(""+appointment.getContactName());

        TextView textView3 = (TextView)view.findViewById(R.id.afspraak_list_location);
        textView3.setText(""+appointment.getLocation());


        return view;
    }
}
