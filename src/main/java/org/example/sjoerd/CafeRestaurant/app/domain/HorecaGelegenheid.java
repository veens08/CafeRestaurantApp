package org.example.sjoerd.CafeRestaurant.app.domain;

import java.util.Arrays;

public class HorecaGelegenheid {
    private String naamHG;
    private String telnrHG;
    private String emailHG;
    private Tafel [] tafels;


    public HorecaGelegenheid() {
        this.naamHG = null;
        this.telnrHG = null;
        this.emailHG = null;
        this.tafels = null;
    }

    public HorecaGelegenheid(String newNaamHG, String newTelnrHG, String newEmailHG, Tafel[] newTafel) {
        setNaamHG (newNaamHG);
        setTelnrHG (newTelnrHG);
        setEmailHG (newEmailHG);
        setTafels (newTafel);
    }

    public String getNaamHG() {
        return naamHG;
    }

    public void setNaamHG(String naamHG) {
        this.naamHG = naamHG;
    }

    public String getTelnrHG() {
        return telnrHG;
    }

    public void setTelnrHG(String telnrHG) {
        this.telnrHG = telnrHG;
    }

    public String getEmailHG() {
        return emailHG;
    }

    public void setEmailHG(String emailHG) {
        this.emailHG = emailHG;
    }

    public Tafel[] getTafels() {
        return tafels;
    }

    public void setTafels(Tafel[] tafels) {
        this.tafels = tafels;
    }

    @Override
    public String toString() {
        return "HorecaGelegenheid{" +
                "naamHG= '" + naamHG + '\'' +
                ", telnrHG= '" + telnrHG + '\'' +
                ", emailHG= '" + emailHG + '\'' +
                ", tafel= " + Arrays.toString (tafels) +
                '}';
    }

}

