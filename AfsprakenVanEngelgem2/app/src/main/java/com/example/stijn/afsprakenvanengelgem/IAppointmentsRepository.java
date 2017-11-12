package com.example.stijn.afsprakenvanengelgem;

import java.util.List;

/**
 * Created by stijn on 10/11/2017.
 */

public interface IAppointmentsRepository {
    List<Appointment> getAppointments();
}