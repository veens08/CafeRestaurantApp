package org.example.sjoerd.CafeRestaurantApp;

import org.example.sjoerd.CafeRestaurant.app.domain.HorecaGelegenheid;
import org.example.sjoerd.CafeRestaurant.app.domain.Persoon;
import org.example.sjoerd.CafeRestaurant.app.domain.Tafel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMaakCafe {

        private static final int AANTAL_TAFELS_HG = 5;

    @Test
    void testMaakCafe () {
        // Vul de horeca gegevens
        HorecaGelegenheid cafe = maakHorecaGelegenheid ();

        // Voeg personen toe
        List<Persoon> personen = (List<Persoon>) maakTestPersonAan ();

        int aantalPersonen = personen.size ();
        System.out.println (aantalPersonen);

        for (int index = 0; index < aantalPersonen; index++) {
            System.out.println (personen.get(index).toString ());
        }
    }


    private HorecaGelegenheid maakHorecaGelegenheid() {
        // Vul de cafe gegevens
        Tafel[] cafetafels = vulTafels ();
        HorecaGelegenheid cafe = new HorecaGelegenheid("Café de Hamer","055-5214007","wenum-wiesel@cafedehamer.nl" , cafetafels);
        return cafe;
    }

    private Tafel [] vulTafels() {

        Tafel [] tafels = new Tafel[AANTAL_TAFELS_HG];
        for (int index = 0; index < AANTAL_TAFELS_HG; index++ ) {
            tafels [index] = new Tafel (index + 1,4);
        }
        return tafels;
    }

    private List<Persoon> maakTestPersonAan() {
        Persoon cas = new Persoon ("Cas", "055-8445104", "Cas12@gmail.com", null);
        Persoon cees = new Persoon ("Cees", "055-8446214", "Cees99@gmail.com", null);
        Persoon jos = new Persoon ("Jos", "055-8445985", "Jos12@gmail.com", null);
        Persoon jan = new Persoon ("Jan", "055-8455514", "Jan99@gmail.com", null);
        Persoon dolf = new Persoon ("Dolf", "050-8445104", "Dolf11@gmail.com", null);
        Persoon dre = new Persoon ("Dre", "050-8446214", "Dreetje99@gmail.com", null);
        List<Persoon> personen = new ArrayList<Persoon> ();

        personen.add(cas);
        personen.add (cees);
        personen.add(jos);
        personen.add (jan);
        personen.add(dolf);
        personen.add (dre);

        return personen;
    }
}
