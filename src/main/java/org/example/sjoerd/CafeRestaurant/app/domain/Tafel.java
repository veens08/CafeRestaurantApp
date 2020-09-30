package org.example.sjoerd.CafeRestaurant.app.domain;

public class Tafel {
    private int tafelNummer;
    private int tafelCapaciteit;

    public static final int AANTAL_TAFELS_HG = 15;

    public Tafel (){
        setTafelNummer (0);
        setTafelCapaciteit (0);
    }

    public Tafel(int newTafelNummer, int newTafelCapaciteit) {
        setTafelNummer (newTafelNummer);
        setTafelCapaciteit (newTafelCapaciteit);
    }

    public int getTafelNummer() {
        return tafelNummer;
    }

    public void setTafelNummer(int tafelNummer) {
        this.tafelNummer = tafelNummer;
    }

    public int getTafelCapaciteit() {
        return tafelCapaciteit;
    }

    public void setTafelCapaciteit(int tafelCapaciteit) {
        this.tafelCapaciteit = tafelCapaciteit;
    }
}
