package org.example.sjoerd.CafeRestaurantApp;

import org.example.sjoerd.CafeRestaurant.app.domain.HorecaGelegenheid;
import org.example.sjoerd.CafeRestaurant.app.domain.Persoon;
import org.example.sjoerd.CafeRestaurant.app.domain.Reservering;
import org.example.sjoerd.CafeRestaurant.app.domain.Tafel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMaakCafe {

        private static final int AANTAL_TAFELS_HG = 5;
        private static final int AANTAL_TOEGESTANE_GASTEN = 15;
        private static final String NOG_EEN_RESERVERING = "J";

    @Test
    void testReserveringenInEenCafe () {

        HorecaGelegenheid cafe = maakHorecaGelegenheid ();

        List<Persoon> personen = (List<Persoon>) maakTestPersonenAan ();

        List<Reservering> reserveringen = (List<Reservering>) maakTestReserveringenAan ();

        neemEenReserveringAan (reserveringen);
    }

    private void neemEenReserveringAan(List<Reservering> reserveringen) {
        String volgendeReservering = NOG_EEN_RESERVERING;
        while (volgendeReservering.equals (NOG_EEN_RESERVERING)) {
            Reservering nieuweReservering = maakReserveringOpConsoleAan ();

            boolean reserveringIsToegestaan = testTotaalAantalPersonenVanReserveringen (reserveringen, nieuweReservering);

            verwerkNieuweReservering (reserveringen, reserveringIsToegestaan);

            volgendeReservering = vraagOmNieuweReservering ();
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

    private List<Persoon> maakTestPersonenAan() {
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
        Reservering tafel1 = new Reservering ("11-10-2020", 1600, 1900, "Cas", 4);
        Reservering tafel2 = new Reservering ("11-10-2020", 1600, 1900, "Jos", 4);
        Reservering tafel3 = new Reservering ("11-10-2020", 1700, 1900, "Dre", 4);
        Reservering tafel4 = new Reservering ("11-10-2020", 1700, 1900, "Cees", 4);
        Reservering tafel5 = new Reservering ("11-10-2020", 1700, 1900, "Dolf", 4);
        Reservering tafel6 = new Reservering ("11-10-2020", 1900, 1900, "Jan", 4);
        Reservering tafel7 = new Reservering ("11-10-2020", 1900, 1900, "Cas", 4);
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
    private Reservering maakReserveringOpConsoleAan() {

        System.out.println ("Geef de reserveringsdatum (dd-mm-eejj) door : ");
        String reserveringsDatum = vraagStringInvoer ();
        String tekstVeld = "de begintijd (uumm)";
        int tijdVanaf = numeriekeInvoerTest (tekstVeld);
        int tijdTot = 0;

        if (tijdVanaf == 1700 || tijdVanaf == 1900) {
            tijdTot = tijdVanaf + 200;
        } else {
            tijdTot = tijdVanaf + 100;
        }

        System.out.println ("Geef de reserveringsnaam door : ");
        String reserveringsNaam = vraagStringInvoer ();
        tekstVeld = "het aantal personen";
        int aantalPersonen = numeriekeInvoerTest (tekstVeld);

        System.out.println ("Datum: " + reserveringsDatum + " Tijd: " + tijdVanaf + " Aantal personen: " + aantalPersonen);

        Reservering nieuweReservering = new Reservering
                                        (reserveringsDatum,
                                        tijdVanaf,
                                        tijdTot,
                                        reserveringsNaam,
                                        aantalPersonen);
        return nieuweReservering;
    }

    private int numeriekeInvoerTest(String tekstVeld) {

        boolean numeriekeInvoer = false;
        int numeriekeWaarde = 0;
        while (numeriekeInvoer == false) {
            System.out.println ("Geef " + tekstVeld + " door: ");
            String numeriekeTekst = vraagStringInvoer ();
            numeriekeInvoer = isNumeric (numeriekeTekst);
            if (numeriekeInvoer == true) {
                numeriekeWaarde = Integer.parseInt (numeriekeTekst);
            } else {
                System.out.println ("Geen numerieke invoer!!!");
            }
        }
        return numeriekeWaarde;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int geheelGetal = Integer.parseInt (strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private String vraagStringInvoer() {
        Scanner scanner = new Scanner (System.in);
        String invoerString = scanner.next();
        return invoerString;
    }

    private boolean testTotaalAantalPersonenVanReserveringen(List<Reservering> reserveringen, Reservering nieuweReservering) {

        boolean reserveringToegestaan = true;
        int totaalAantalPersonen = nieuweReservering.getAantalPersonen ();
        int aantalReserveringen = reserveringen.size ();
        for (int index = 0; index < aantalReserveringen; index++) {
            if (reserveringen.get (index).getReserveringsDatum ().equals (nieuweReservering.getReserveringsDatum ())) {
                if (reserveringen.get (index).getReserveringVanaf () == nieuweReservering.getReserveringVanaf ()) {
                    totaalAantalPersonen = totaalAantalPersonen + reserveringen.get (index).getAantalPersonen ();
                }
            }
        }
        System.out.println (totaalAantalPersonen);
        if (totaalAantalPersonen > AANTAL_TOEGESTANE_GASTEN) {
            reserveringToegestaan = false;
        } else {
            reserveringen.add(nieuweReservering);
        }
        return reserveringToegestaan;
    }

    private void verwerkNieuweReservering(List<Reservering> reserveringen, boolean reserveringIsToegestaan) {
        int aantalReserveringen = reserveringen.size ();
        if (reserveringIsToegestaan) {
            System.out.println ("Reservering is gemaakt");
        } else {
            System.out.println ("Reservering afgewezen, te veel gasten");
        }
        System.out.println ("Aantal reserveringen: " + aantalReserveringen);

        for (int index = 0; index < aantalReserveringen; index++) {
            System.out.println (reserveringen.get (index).toString ());
        }
    }

    private String vraagOmNieuweReservering() {
        System.out.println ("Wilt u nog een reservering opvoeren (J/N): ");
        String nieuweReservering = vraagStringInvoer ();
        return nieuweReservering;
    }
}
