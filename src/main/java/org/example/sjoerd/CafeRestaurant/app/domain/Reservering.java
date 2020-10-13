package org.example.sjoerd.CafeRestaurant.app.domain;

import java.time.LocalDate;
import java.util.Date;

public class Reservering {
    private String reserveringsDatum;
    private int reserveringVanaf;
    private int reserveringTot;
    private String naamReservering;
    private int aantalPersonen;

    public Reservering () {
        this.reserveringsDatum = null;
        this.reserveringVanaf = 0;
        this.reserveringTot = 0;
        this.naamReservering = null;
        this.aantalPersonen = 0;
    }

    public Reservering (String newReserveringsDatum, int newReserveringVanaf, int newReserveringTot, String newNaamReservering, int newAantalPersonen) {
        setReserveringsDatum (newReserveringsDatum);
        setReserveringVanaf (newReserveringVanaf);
        setReserveringTot (newReserveringTot);
        setNaamReservering (newNaamReservering);
        setAantalPersonen (newAantalPersonen);
    }

    public String getReserveringsDatum() {
        return reserveringsDatum;
    }

    public void setReserveringsDatum(String reserveringsDatum) {
        this.reserveringsDatum = reserveringsDatum;
    }

    public int getReserveringVanaf() {
        return reserveringVanaf;
    }

    public void setReserveringVanaf(int reserveringVanaf) {
        this.reserveringVanaf = reserveringVanaf;
    }

    public int getReserveringTot() {
        return reserveringTot;
    }

    public void setReserveringTot(int newReserveringTot) {
        if (this.reserveringVanaf == 1700 || this.reserveringVanaf == 1900) {
            this.reserveringTot = this.reserveringVanaf + 200;
        } else {
            this.reserveringTot = this.reserveringVanaf + 100;
        }
    }

    public String getNaamReservering() {
        return naamReservering;
    }

    public void setNaamReservering(String naamReservering) {
        this.naamReservering = naamReservering;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    @Override
    public String toString() {
        return "Reservering{" +
                "reserveringsDatum='" + reserveringsDatum + '\'' +
                ", reserveringVanaf=" + reserveringVanaf +
                ", reserveringTot=" + reserveringTot +
                ", naamReservering='" + naamReservering + '\'' +
                ", aantalPersonen=" + aantalPersonen +
                '}';
    }
}
