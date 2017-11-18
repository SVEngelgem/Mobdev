package com.example.stijn.afsprakenvanengelgem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stijn on 10/11/2017.
 */

public class AppointmentDummyRepository implements IAppointmentsRepository {

        private static IAppointmentsRepository repo = null;

    public static IAppointmentsRepository getInstance() {
        if (repo == null) {
            repo = new AppointmentDummyRepository();
        }
        return repo;
    }

    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();

        appointments.add(new Appointment(1,R.drawable.doctor1, 3, 4, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Knie doet lastig.","geo:0,0?q=UZA"));
        appointments.add(new Appointment(2, R.drawable.doctor2,4, 3, 2018, 9, 15, "Dr. Geneens", "AZ Monica 04.04", "Wijsheidstanden voorbereiding operatie.","geo:0,0?q=GZA Ziekenhuizen campus Sint-Jozef"));
        appointments.add(new Appointment(3, R.drawable.doctor1,12, 3, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Knie doet lastiger.","geo:0,0?q=UZA"));
        appointments.add(new Appointment(4, R.drawable.doctor3,18, 4, 2018, 9, 15, "Dr. Cryns", "AZ Klina 03.04", "Eerste echo baby","geo:51.2068387,4.3985725"));
        appointments.add(new Appointment(4, R.drawable.doctor1,25, 3, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "MRI scan knie.","geo:0,0?q=UZA"));
        appointments.add(new Appointment(5, R.drawable.doctor3,18, 4, 2018, 9, 15, "Dr. Cryns", "AZ Klina 03.04", "Tweede echo baby","geo:51.2068387,4.3985725"));
        appointments.add(new Appointment(6, R.drawable.doctor4,30, 4, 2018, 9, 15, "Dr. Geneejnes", "AZ Monica 04.04", "Wijsheidstanden trekken","geo:51.2258037,4.410499?q=Pauwels / Martha"));
        appointments.add(new Appointment(7, R.drawable.doctor1,4, 5, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Evaluatie MRI scan knie.","geo:0,0?q=UZA"));
        appointments.add(new Appointment(8,  R.drawable.doctor2,20, 5, 2018, 9, 15, "Dr. Geneens", "AZ Monica 04.04", "Controle wijsheidstanden operatie","geo:0,0?q=GZA Ziekenhuizen campus Sint-Jozef"));
        appointments.add(new Appointment(9, R.drawable.doctor1,1, 6, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Voorbereiding onderzoek knie prothese.","geo:0,0?q=UZA"));
        appointments.add(new Appointment(10, R.drawable.doctor3,21, 6, 2018, 9, 15, "Dr. Cryns", "AZ Klina 03.04", "Derde echo baby","geo:51.2068387,4.3985725"));
        appointments.add(new Appointment(11, R.drawable.doctor1,23, 6, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Aanvaarding knie prothese tijdens zwangerschap","geo:0,0?q=UZA"));
        appointments.add(new Appointment(13, R.drawable.doctor3,1, 8, 2018, 9, 15, "Dr. Cryns", "AZ Klina 03.04", "Vruchtwaterprik","geo:51.2068387,4.3985725"));
        appointments.add(new Appointment(14, R.drawable.doctor1,4, 8, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Vragenlijst ingevuld operatie knie prothese","geo:0,0?q=UZA"));
        appointments.add(new Appointment(15, R.drawable.doctor1,20, 8, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Operatie knie prothese","geo:0,0?q=UZA"));
        appointments.add(new Appointment(16, R.drawable.doctor1,2, 9, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Evaluatie operatie knie prothese","geo:0,0?q=UZA"));
        appointments.add(new Appointment(17,  R.drawable.doctor2,5, 9, 2018, 9, 15, "Dr. Geneens", "AZ Monica 04.04", "Tweede controle wijsheidstanden operatie","geo:0,0?q=GZA Ziekenhuizen campus Sint-Jozef"));
        appointments.add(new Appointment(18, R.drawable.doctor1,6, 9, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Revalidatie knie prothese sessie 1","geo:0,0?q=UZA"));
        appointments.add(new Appointment(20, R.drawable.doctor3,12, 10, 2018, 9, 15, "Dr. Cryns", "AZ Klina 03.04", "Vierde echo baby","geo:51.2068387,4.3985725"));
        appointments.add(new Appointment(21, R.drawable.doctor1,18, 10, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Revalidatie knie prothese sessie 2","geo:0,0?q=UZA"));
        appointments.add(new Appointment(22, R.drawable.doctor3,21, 10, 2018, 9, 15, "Dr. Cryns", "AZ Klina 03.04", "Tweede echo baby","geo:51.2068387,4.3985725"));
        appointments.add(new Appointment(23, R.drawable.doctor1,27, 10, 2018, 9, 15, "Dr. Van Limburgen", "AZ Klina 02.04", "Ontslag evaluatie knie prothese ","geo:0,0?q=UZA"));
        appointments.add(new Appointment(24,  R.drawable.doctor2,3, 11, 2018, 9, 15, "Dr. Geneens", "AZ Monica 04.04", "Afspraak gereserveerd voor moesten wijsheidstanden teruggroeien.","geo:0,0?q=GZA Ziekenhuizen campus Sint-Jozef"));
        appointments.add(new Appointment(25, R.drawable.doctor3,12, 11, 2018, 9, 15, "Dr. Cryns", "AZ Klina 03.04", "Voorberiding keizersnede","geo:51.2068387,4.3985725"));
        appointments.add(new Appointment(26,  R.drawable.doctor2,19, 11, 2018, 9, 15, "Dr. Geneens", "AZ Monica 04.04", "Ontslag knie prothese","geo:0,0?q=GZA Ziekenhuizen campus Sint-Jozef"));
        appointments.add(new Appointment(27, R.drawable.doctor3,24, 12, 2018, 9, 15, "Dr. Cryns", "AZ Klina 03.04", "Kerstmis babydrink","geo:51.2068387,4.3985725"));

        return appointments;
    }
}
