package org.example.sjoerd.CafeRestaurantApp;

import org.example.sjoerd.CafeRestaurant.app.domain.HorecaGelegenheid;
import org.example.sjoerd.CafeRestaurant.app.domain.Tafel;
import org.junit.jupiter.api.Test;

public class TestMaakCafe {

        private static final int AANTAL_TAFELS_HG = 5;

    @Test
    void testMaakCafe () {
        // Vul de horeca gegevens
        HorecaGelegenheid cafe = maakHorecaGelegenheid ();

        Tafel tafel1 = cafe.getTafels ()[1];
        System.out.println (tafel1);
        System.out.println (cafe);
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

}
