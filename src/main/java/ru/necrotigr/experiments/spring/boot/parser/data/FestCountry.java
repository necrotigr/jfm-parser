package ru.necrotigr.experiments.spring.boot.parser.data;

import ru.necrotigr.experiments.spring.boot.api.Country;

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
