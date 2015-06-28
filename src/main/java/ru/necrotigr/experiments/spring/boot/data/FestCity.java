package ru.necrotigr.experiments.spring.boot.data;

import ru.necrotigr.experiments.spring.boot.api.City;
import ru.necrotigr.experiments.spring.boot.api.Country;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
public class FestCity implements City {

    private String name;
    private Country country;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Country getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
