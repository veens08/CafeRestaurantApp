package org.example.sjoerd.CafeRestaurant.app.domain;

import java.util.regex.Pattern;

public class FormaatDatum {

    private static Pattern DATUM_FORMAAT = Pattern.compile(
                "^\\d{2}-\\d{2}-\\d{4}$");

    //    @Override
    public boolean datumFormaatControle(String datum) {
        return DATUM_FORMAAT.matcher (datum).matches ();
    }
}
