package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location.parsers;

import net.jazzfestmap.app.parser.api.City;
import net.jazzfestmap.app.parser.api.Country;
import net.jazzfestmap.app.parser.parser.data.FestCity;
import net.jazzfestmap.app.parser.parser.data.FestCountry;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location.LocationStrParser;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Сергей on 16.02.2017.
 */
public class CityRegionCountryParser implements LocationStrParser {

    /**
     * Surry Hills, New South Wales, Australia
     * @param locationStr
     * @return
     */
    @Override
    public Collection<City> parse(String locationStr) {
        String[] parts = locationStr.split(",");
        String cityStr = parts[0] + parts[1];
        String countryStr = parts[2];
        Country country = new FestCountry(countryStr);
        FestCity city = new FestCity();
        city.setName(cityStr);
        city.setCountry(country);
        return Collections.singletonList(city);
    }
}
