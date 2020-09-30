package org.example.sjoerd.CafeRestaurant.app.domain;

public class Reservering {
    private String reserveringsDatum;
    private String reserveringVanaf;
    private String reserveringTot;
    private String naamReservering;

    public Reservering (String newReserveringsDatum, String newReserveringVanaf, String newReserveringTot, String newNaamReservering) {
        setReserveringsDatum (newReserveringsDatum);
        setReserveringVanaf (newReserveringVanaf);
        setReserveringTot (newReserveringTot);
        setNaamReservering (newNaamReservering);
    }

    public String getReserveringsDatum() {
        return reserveringsDatum;
    }

    public void setReserveringsDatum(String reserveringsDatum) {
        this.reserveringsDatum = reserveringsDatum;
    }

    public String getReserveringVanaf() {
        return reserveringVanaf;
    }

    public void setReserveringVanaf(String reserveringVanaf) {
        this.reserveringVanaf = reserveringVanaf;
    }

    public String getReserveringTot() {
        return reserveringTot;
    }

    public void setReserveringTot(String reserveringTot) {
        this.reserveringTot = reserveringTot;
    }

    public String getNaamReservering() {
        return naamReservering;
    }

    public void setNaamReservering(String naamReservering) {
        this.naamReservering = naamReservering;
    }
}
