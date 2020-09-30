package org.example.sjoerd.CafeRestaurant.app.domain;

public class HorecaGelegenheid {
    private String naamHG;
    private String telnrHG;
    private String emailHG;

    public HorecaGelegenheid() {
    }

    public HorecaGelegenheid(String newNaamHG, String newTelnrHG, String newEmailHG) {
        setNaamHG (newNaamHG);
        setTelnrHG (newTelnrHG);
        setEmailHG (newEmailHG);
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

}

