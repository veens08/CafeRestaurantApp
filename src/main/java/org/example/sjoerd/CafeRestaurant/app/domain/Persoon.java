package org.example.sjoerd.CafeRestaurant.app.domain;

public class Persoon {
    private String naamPersoon;
    private String telnrPersoon;
    private String emailPersoon;

    // Teller van de personen ivm. groepsgroote
    private static int aantalPersonen;

    public static final String NAAM_ONBEKEND = null;
    public static final String GEEN_TELNR = null;
    public static final String GEEN_EMAIL_ADRES = null;

    public Persoon () {
        this(NAAM_ONBEKEND, GEEN_TELNR, GEEN_EMAIL_ADRES);
    }

    public Persoon (String newNaamPersoon, String newTelnrPersoon) {
        this(newNaamPersoon, newTelnrPersoon, GEEN_EMAIL_ADRES);
    }

    public Persoon (String newNaamPersoon, String newTelnrPersoon, String newEmailPersoon) {
        aantalPersonen = aantalPersonen + 1;
        setNaamPersoon (newNaamPersoon);
        setTelnrPersoon (newTelnrPersoon);
        setEmailPersoon (newEmailPersoon);
    }

    private void setStateObject (String newNaamPersoon, String newTelnrPersoon, String newEmailPersoon) {
        aantalPersonen = aantalPersonen + 1;
        setNaamPersoon (newNaamPersoon);
        setTelnrPersoon (newTelnrPersoon);
        setEmailPersoon (newEmailPersoon);
    }

    public static int getAantalPersonen() {
        return Persoon.aantalPersonen;
    }

    public String getNaamPersoon() {
        return naamPersoon;
    }

    public void setNaamPersoon(String naamPersoon) {
        this.naamPersoon = naamPersoon;
    }

    public String getTelnrPersoon() {
        return telnrPersoon;
    }

    public void setTelnrPersoon(String telnrPersoon) {
        this.telnrPersoon = telnrPersoon;
    }

    public String getEmailPersoon() {
        return emailPersoon;
    }

    public void setEmailPersoon(String emailPersoon) {
        this.emailPersoon = emailPersoon;
    }
}
