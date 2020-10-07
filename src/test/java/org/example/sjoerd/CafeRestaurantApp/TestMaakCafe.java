package org.example.sjoerd.CafeRestaurantApp;

import org.example.sjoerd.CafeRestaurant.app.domain.HorecaGelegenheid;
import org.example.sjoerd.CafeRestaurant.app.domain.Persoon;
import org.example.sjoerd.CafeRestaurant.app.domain.Reservering;
import org.example.sjoerd.CafeRestaurant.app.domain.Tafel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMaakCafe {

        private static final int AANTAL_TAFELS_HG = 5;

    @Test
    void testMaakCafe () {
        // Vul de horeca gegevens
        HorecaGelegenheid cafe = maakHorecaGelegenheid ();

        // Voeg personen toe
        List<Persoon> personen = (List<Persoon>) maakTestPersonAan ();

        // Voeg reserveringen toe
        List<Reservering> reserveringen = (List<Reservering>) maakTestReserveringenAan ();

        int aantalReserveringen = reserveringen.size ();

        // Reservering via console aanmaken
        maakReserveringOpConsoleAan ((ArrayList<Reservering>) reserveringen);

        personen.get (0).setHeeftReservering (reserveringen.get (0));
        personen.get (0).setNaamPersoon ("Cees");
        System.out.println (personen.get (0).toString ());

        aantalReserveringen = reserveringen.size ();

        for (int index = 0; index < aantalReserveringen; index++) {
            System.out.println (reserveringen.get (index).toString ());
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

    private List<Reservering> maakTestReserveringenAan() {
        Reservering tafel1 = new Reservering ("11-10-2020", 1700, 1900, "Cas", 4);
        Reservering tafel2 = new Reservering ("11-10-2020", 1700, 1900, "Jos", 4);
        Reservering tafel3 = new Reservering ("11-10-2020", 1700, 1900, "Dre", 4);
        Reservering tafel4 = new Reservering ("11-10-2020", 1700, 1900, "Cees", 4);
        Reservering tafel5 = new Reservering ("11-10-2020", 1700, 1900, "Dolf", 4);
        Reservering tafel6 = new Reservering ("11-10-2020", 1700, 1900, "Jan", 4);
        Reservering tafel7 = new Reservering ("11-10-2020", 1700, 1900, "Jan", 4);
        List<Reservering> reserveringen = new ArrayList<Reservering> ();

        reserveringen.add(tafel1);
        reserveringen.add(tafel2);
        reserveringen.add(tafel3);
        reserveringen.add(tafel4);
        reserveringen.add(tafel5);
        reserveringen.add(tafel6);
        reserveringen.add(tafel7);

        return reserveringen;
    }
    private void maakReserveringOpConsoleAan(ArrayList<Reservering> reserveringen) {
        //Reservering gegevens ingeven via console
        System.out.println ("Geef de reserveringsdatum (dd-mm-eejj) door : ");
        String reserveringsDatum = vraagStringInvoer ();
        System.out.println ("Geef de begintijd (uumm) door: ");
        int tijdVanaf = vraagIntegerInvoer ();
        int tijdTot = 0;

        if (tijdVanaf == 1700 || tijdVanaf == 1900) {
            tijdTot = tijdVanaf + 200;
        } else {
            tijdTot = tijdVanaf + 100;
        }

        System.out.println ("Geef de reserveringsnaam door : ");
        String reserveringsNaam = vraagStringInvoer ();
        System.out.println ("Geef het aantal personen door: ");
        int aantalPersonen = vraagIntegerInvoer ();

        reserveringen.add (new Reservering (reserveringsDatum,
                tijdVanaf,
                tijdTot,
                reserveringsNaam,
                aantalPersonen));
    }

    private String vraagStringInvoer() {
        Scanner scanner = new Scanner (System.in);
        String invoerString = scanner.next();
        return invoerString;
    }

    private int vraagIntegerInvoer() {
        Scanner scanner = new Scanner (System.in);
        int invoerInteger = scanner.nextInt();
        return invoerInteger;
    }
}
