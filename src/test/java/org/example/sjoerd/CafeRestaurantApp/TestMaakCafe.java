package org.example.sjoerd.CafeRestaurantApp;

import org.example.sjoerd.CafeRestaurant.app.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE;

public class TestMaakCafe {

    private static final int AANTAL_TAFELS_HG = 5;
    private static final int AANTAL_TOEGESTANE_GASTEN = 15;
    private static final String NOG_EEN_RESERVERING = "J";

    private static Pattern DATUM_FORMAAT = Pattern.compile(
            "^\\d{2}-\\d{2}-\\d{4}$");

    private static Pattern DATUM_GELDIGHEID = Pattern.compile(
            "^(29-02-(2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$"
                    + "|^(((0[1-9]|1[0-9]|2[0-8])-02-(19|2[0-9])[0-9]{2}))$"
                    + "|^(((0[1-9]|[12][0-9]|3[01])-(0[13578]|10|12)-(19|2[0-9])[0-9]{2}))$"
                    + "|^(((0[1-9]|[12][0-9]|30)-(0[469]|11)-(19|2[0-9])[0-9]{2}))$");

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

        String reserveringsDatum = datumInvoerTest ();

        String tekstVeld = "de begintijd (uumm)";
        int tijdVanaf = numeriekeInvoerTest (tekstVeld);

        System.out.println ("Geef de reserveringsnaam door : ");
        String reserveringsNaam = vraagStringInvoer ();
        tekstVeld = "het aantal personen";
        int aantalPersonen = numeriekeInvoerTest (tekstVeld);

        System.out.println ("Datum: " + reserveringsDatum + " Tijd: " + tijdVanaf + " Aantal personen: " + aantalPersonen);

        Reservering nieuweReservering = new Reservering
                                        (reserveringsDatum,
                                        tijdVanaf,
                                        0,
                                        reserveringsNaam,
                                        aantalPersonen);
        return nieuweReservering;
    }

    private String datumInvoerTest() {

        boolean datumOnjuist = false;
        String invoerDatum = null;

        while (datumOnjuist == false) {
            System.out.println ("Geef de reserveringsdatum (dd-mm-eejj) door : ");
            invoerDatum = vraagStringInvoer ();

            datumOnjuist = DATUM_FORMAAT.matcher (invoerDatum).matches ();
            if (datumOnjuist == false) {
                System.out.println ("Onjuist datum formaat ingevoerd!!!");
            } else {
                datumOnjuist = DATUM_GELDIGHEID.matcher (invoerDatum).matches ();
                if (datumOnjuist == false) {
                    System.out.println ("Geen geldige datum ingevoerd!!!");
                }
            }
        }
        return invoerDatum;
    }

    private int numeriekeInvoerTest(String tekstVeld) {

        boolean fouteNumeriekeInvoer = false;

        int numeriekeWaarde = 0;
        while (fouteNumeriekeInvoer == false) {
            System.out.println ("Geef " + tekstVeld + " door: ");
            String numeriekeTekst = vraagStringInvoer ();
            fouteNumeriekeInvoer = true;
            try {
                numeriekeWaarde = Integer.parseInt (numeriekeTekst);
            } catch (NumberFormatException nfe) {
                System.out.println ("Geen numerieke invoer!!");
                fouteNumeriekeInvoer = false;
            }
            fouteNumeriekeInvoer = foutieveWaarde (tekstVeld, fouteNumeriekeInvoer, numeriekeWaarde);
        }
        return numeriekeWaarde;
    }

    private boolean foutieveWaarde(String tekstVeld, boolean fouteNumeriekeWaarde, int numeriekeWaarde) {
        if (fouteNumeriekeWaarde == true && tekstVeld.equals ("de begintijd (uumm)")) {
            if (numeriekeWaarde != 1200 &&
                numeriekeWaarde != 1300 &&
                numeriekeWaarde != 1400 &&
                numeriekeWaarde != 1500 &&
                numeriekeWaarde != 1600 &&
                numeriekeWaarde != 1700 &&
                numeriekeWaarde != 1900) {
                System.out.println ("Foutief tijdstip ingevoerd, alleen 1200, 1300, 1400, 1500, 1600, 1700 of 1900 toegestaan!!");
                fouteNumeriekeWaarde = false;
            }
        }
        return fouteNumeriekeWaarde;
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
