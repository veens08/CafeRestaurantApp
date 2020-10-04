package org.example.sjoerd.CafeRestaurant.app.domain;

public class Reservering {
    private String reserveringsDatum;
    private int reserveringVanaf;
    private int reserveringTot;
    private String naamReservering;
    private int aantalPersonen;

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

    public void setReserveringTot(int reserveringTot) {
        this.reserveringTot = reserveringTot;
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
}