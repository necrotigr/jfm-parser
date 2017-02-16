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
public class CityStateCountryParser implements LocationStrParser {
    @Override
    public Collection<City> parse(String locationStr) {
        return new CityRegionCountryParser().parse(locationStr);
    }
}
