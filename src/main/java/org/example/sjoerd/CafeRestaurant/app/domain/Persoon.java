package org.example.sjoerd.CafeRestaurant.app.domain;

public class Persoon {
    private String naamPersoon;
    private String telnrPersoon;
    private String emailPersoon;

    // Teller van de personen ivm. groepsgroote
    private static int aantalPersonen;

    public Persoon () {
        aantalPersonen = aantalPersonen + 1;
        setNaamPersoon (null);
        setTelnrPersoon (null);
        setEmailPersoon (null);
    }

    public Persoon (String newNaamPersoon, String newTelnrPersoon, String newEmailPersoon) {
        aantalPersonen = aantalPersonen + 1;
        setNaamPersoon (newNaamPersoon);
        setTelnrPersoon (newTelnrPersoon);
        setEmailPersoon (newEmailPersoon);
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
