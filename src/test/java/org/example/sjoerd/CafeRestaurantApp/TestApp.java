package org.example.sjoerd.CafeRestaurantApp;

import org.example.sjoerd.CafeRestaurant.app.domain.HorecaGelegenheid;
import org.example.sjoerd.CafeRestaurant.app.domain.Tafel;
import org.junit.jupiter.api.Test;

public class TestApp {

    @Test
    void vulCafe () {

        HorecaGelegenheid cafe = new HorecaGelegenheid();
        cafe.setNaamHG ("Café de Hamer");
        cafe.setTelnrHG ("055-5214007");
        cafe.setEmailHG ("wenum-wiesel@cafedehamer.nl");

        System.out.println (cafe.getNaamHG ());
        System.out.println (cafe.getTelnrHG ());
        System.out.println (cafe.getEmailHG ());
    }

    @Test
    void vulTafels () {
        Tafel t1 = new Tafel (1, 4);
        Tafel t2 = new Tafel (1, 4);
        Tafel t3 = new Tafel (1, 4);
        Tafel t4 = new Tafel (1, 4);
        Tafel t5 = new Tafel (1, 4);
        Tafel t6 = new Tafel (1, 4);
        Tafel t7 = new Tafel (1, 4);
        Tafel t8 = new Tafel (1, 4);
        Tafel t9 = new Tafel (1, 4);
        Tafel t10 = new Tafel (1, 4);
        Tafel t11 = new Tafel (1, 6);
        Tafel t12 = new Tafel (1, 6);
        Tafel t13 = new Tafel (1, 6);
        Tafel t14 = new Tafel (1, 6);
        Tafel t15 = new Tafel (1, 6);

        Tafel [] hamerTafels = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15};

        for (Tafel t : hamerTafels) {
            System.out.println ("Tafelnummer = " + t.getTafelNummer () + " capaciteit = " + t.getTafelCapaciteit () );
        }
    }
}
