package com.example.stijn.appoftheyear;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stijn on 19/11/2017.
 */

public class Dranklijst {

    //controle van interface? navragen in vergelijking met appointment opdracht

    public List<Drank> getDrankLijst(){
        List<Drank> Dranken = new ArrayList<>();

        Dranken.add(new FrisDrank("cola", 1.7));
        Dranken.add(new Bier("jupiler", 1.7,"pils",5.2));
        Dranken.add(new Bier("Duvel", 2.8, "blond",8.5 ));
        Dranken.add(new WarmeDranken("Koffie",1.7,"koffie","standaard"));
        Dranken.add(new Whiskey("Belveney", 6,"zacht",20));

        return Dranken;
    }
}
