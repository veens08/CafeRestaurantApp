package org.example.sjoerd.CafeRestaurantApp;

import org.example.sjoerd.CafeRestaurant.app.domain.HorecaGelegenheid;
import org.example.sjoerd.CafeRestaurant.app.domain.Tafel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestApp {

    @Test
    void vulCafe () {

        Tafel [] cafetafels = getTafels ();

        for (Tafel t : cafetafels) {
            System.out.println ("Tafelnummer = " + t.getTafelNummer () + " capaciteit = " + t.getTafelCapaciteit ());
        }

        HorecaGelegenheid cafe = new HorecaGelegenheid("Café de Hamer","055-5214007","wenum-wiesel@cafedehamer.nl" , cafetafels);
        //cafe.setNaamHG ("Café de Hamer");
        //cafe.setTelnrHG ("055-5214007");
        //cafe.setEmailHG ("wenum-wiesel@cafedehamer.nl");

        System.out.println (cafe.getNaamHG ());
        System.out.println (cafe.getTelnrHG ());
        System.out.println (cafe.getEmailHG ());

        }

    private Tafel [] getTafels() {

        Tafel t1 = new Tafel (1, 4);
        Tafel t2 = new Tafel (2, 4);
        Tafel t3 = new Tafel (3, 4);
        Tafel t4 = new Tafel (4, 4);
        Tafel t5 = new Tafel (5, 4);
        Tafel t6 = new Tafel (6, 4);
        Tafel t7 = new Tafel (7, 4);
        Tafel t8 = new Tafel (8, 4);
        Tafel t9 = new Tafel (9, 4);
        Tafel t10 = new Tafel (10, 4);
        Tafel t11 = new Tafel (11, 6);
        Tafel t12 = new Tafel (12, 6);
        Tafel t13 = new Tafel (13, 6);
        Tafel t14 = new Tafel (14, 6);
        Tafel t15 = new Tafel (15, 6);

        return new Tafel []  {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15};

    }
}
