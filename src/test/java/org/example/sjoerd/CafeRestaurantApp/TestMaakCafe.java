package org.example.sjoerd.CafeRestaurantApp;

import org.example.sjoerd.CafeRestaurant.app.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMaakCafe {

    private static final int AANTAL_TAFELS_HG = 5;
    private static final int AANTAL_TOEGESTANE_GASTEN = 15;
    private static final String NOG_EEN_AANVRAAG = "J";
    private static final String RESERVERING = "R";
    private static final String ANNULERING = "A";

    private static Pattern DATUM_FORMAAT = Pattern.compile(
            "^\\d{2}-\\d{2}-\\d{4}$");

    private static Pattern DATUM_GELDIGHEID = Pattern.compile(
            "^(29-02-(2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$"
                    + "|^(((0[1-9]|1[0-9]|2[0-8])-02-(19|2[0-9])[0-9]{2}))$"
                    + "|^(((0[1-9]|[12][0-9]|3[01])-(0[13578]|10|12)-(19|2[0-9])[0-9]{2}))$"
                    + "|^(((0[1-9]|[12][0-9]|30)-(0[469]|11)-(19|2[0-9])[0-9]{2}))$");

    @Test
    void testEenAanvraagInEenCafe () {

        HorecaGelegenheid cafe = maakHorecaGelegenheid ();

        List<Persoon> personen = (List<Persoon>) maakTestPersonenAan ();

        List<Reservering> reserveringen = (List<Reservering>) maakTestReserveringenAan ();

        behandelEenAanvraag (reserveringen);
    }

    private void behandelEenAanvraag(List<Reservering> reserveringen) {
        String volgendeAanvraag = NOG_EEN_AANVRAAG;
        while (volgendeAanvraag.equals (NOG_EEN_AANVRAAG)) {
            String typeAanvraag = verwerkAanvraag ();

            if (typeAanvraag.equals (ANNULERING)) {
                System.out.println ("Kan nog geen annulering invoeren!");
                volgendeAanvraag = verwerkAnnulering (reserveringen);
            } else {
                volgendeAanvraag = maakReservering (reserveringen);
            }
        }
    }

    private String verwerkAnnulering(List<Reservering> reserveringen) {
        String volgendeAanvraag;
        verwerkAnnuleringOpConsole (reserveringen) ;

        volgendeAanvraag = vraagOmNogEenAanvraag ();
        return volgendeAanvraag;
    }

    private String maakReservering(List<Reservering> reserveringen) {
        String volgendeAanvraag;
        Reservering nieuweReservering = maakReserveringOpConsoleAan ();

        verwerkReserveringen (reserveringen, nieuweReservering);

        int aantalReserveringen = reserveringen.size ();
        System.out.println ("Aantal reserveringen: " + aantalReserveringen);

        for (int index = 0; index < aantalReserveringen; index++) {
            System.out.println (reserveringen.get (index).toString ());
        }

        volgendeAanvraag = vraagOmNogEenAanvraag ();
        return volgendeAanvraag;
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
        Reservering tafel1 = new Reservering ("24-10-2020", 1600, 0, "Cas", 4);
        Reservering tafel2 = new Reservering ("24-10-2020", 1600, 0, "Jos", 4);
        Reservering tafel3 = new Reservering ("24-10-2020", 1700, 0, "Dre", 4);
        Reservering tafel4 = new Reservering ("24-10-2020", 1700, 0, "Cees", 4);
        Reservering tafel5 = new Reservering ("24-10-2020", 1700, 0, "Dolf", 4);
        Reservering tafel6 = new Reservering ("24-10-2020", 1900, 0, "Jan", 4);
        Reservering tafel7 = new Reservering ("24-10-2020", 1900, 0, "Cas", 4);
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

    private String verwerkAanvraag() {
        boolean typeAanvraagOnjuist = false;
        String typeAanvraag = null;

        while (typeAanvraagOnjuist == false) {
            System.out.println ("Geef type aanvraag door, annulering of reservering (A/R): ");
            typeAanvraag = vraagStringInvoer ();

            if (typeAanvraag.equals (ANNULERING) || typeAanvraag.equals (RESERVERING)) {
                typeAanvraagOnjuist = true;
            }
            else {
                System.out.println ("Geen geldige waarde ingevoerd!!!");
            }
        }
        return typeAanvraag;
    }

    private void verwerkAnnuleringOpConsole(List<Reservering> reserveringen) {

        String annuleringsDatum = datumInvoerTest ();

        String tekstVeld = "de begintijd (uumm)";
        int tijdAnnuleringVanaf = numeriekeInvoerTest (tekstVeld);

        System.out.println ("Geef de reserveringsnaam door : ");
        String reserveringsNaam = vraagStringInvoer ();

        System.out.println ("Datum: " + annuleringsDatum + " Tijd: " + tijdAnnuleringVanaf + " Naam: " + reserveringsNaam);

        zoekEnVerwijderReservering (reserveringen, annuleringsDatum, tijdAnnuleringVanaf, reserveringsNaam);

        int aantalReserveringen = reserveringen.size ();
        for (int index = 0; index < aantalReserveringen; index++) {
            System.out.println (reserveringen.get (index).toString ());
        }
    }

    private void zoekEnVerwijderReservering(List<Reservering> reserveringen, String annuleringsDatum, int tijdAnnuleringVanaf, String reserveringsNaam) {
        int aantalReserveringen = reserveringen.size ();
        int index = 0;
        boolean reserveringGevonden = false;

        while (index < aantalReserveringen && !reserveringGevonden) {
            if ((reserveringen.get (index).getReserveringsDatum ().equals (annuleringsDatum)) &&
                (reserveringen.get (index).getReserveringVanaf () == tijdAnnuleringVanaf) &&
                (reserveringen.get (index).getNaamReservering ().equals (reserveringsNaam))) {
                    reserveringGevonden = true;
                    reserveringen.remove (index);
                System.out.println ("Annulering verwerkt");
            } else {
                    System.out.println ("Reservering niet gevonden");
            }
            index++;
         }
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

    private void verwerkReserveringen(List<Reservering> reserveringen, Reservering nieuweReservering) {

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
            System.out.println ("Reservering afgewezen, te veel gasten");
        } else {
            reserveringen.add(nieuweReservering);
            System.out.println ("Reservering is gemaakt");
        }
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

    private void verwerkReserveringen(List<Reservering> reserveringen, Reservering nieuweReservering) {

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
            System.out.println ("Reservering afgewezen, te veel gasten");
        } else {
            reserveringen.add(nieuweReservering);
            System.out.println ("Reservering is gemaakt");
        }
    }

    private String vraagOmNogEenAanvraag() {
        System.out.println ("Wilt u nog een annulering of reservering opvoeren (J/N): ");
        String nieuweReservering = vraagStringInvoer ();
        return nieuweReservering;
    }
}
