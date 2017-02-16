package net.jazzfestmap.app.parser.parser.data;

import net.jazzfestmap.app.parser.api.Country;

/**
 * Created by Сергей on 28.06.2015.
 */
public class FestCountry implements Country {

    private String name;

    public FestCountry(String countryStr) {
        this.name = countryStr;
    }

    @Override
    public String getName() {
        return name;
    }
}
