package org.example.sjoerd.CafeRestaurant.app.domain;

public class Tafel {
    private int tafelNummer;
    private int tafelCapaciteit;



    public Tafel() {
        this.tafelNummer = 0;
        this.tafelCapaciteit = 0;
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

    @Override
    public String toString() {
        return "Tafel{" +
                "tafelNummer= " + tafelNummer +
                ", tafelCapaciteit= " + tafelCapaciteit +
                '}';
    }
}
