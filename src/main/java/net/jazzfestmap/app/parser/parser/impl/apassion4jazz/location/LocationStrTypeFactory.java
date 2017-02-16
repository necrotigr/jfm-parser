package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location;

import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location.parsers.CityCountryParser;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location.parsers.CityRegionCountryParser;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location.parsers.CityStateCountryParser;

/**
 * Created by Сергей on 16.02.2017.
 */
public class LocationStrTypeFactory {

    public static LocationStrParser create(LocationStrType locationStrType) throws UnsupportedLocationStrTypeException {
        switch (locationStrType) {
            case CITY_COUNTRY: return new CityCountryParser();
            case CITY_STATE_COUNTRY: return new CityStateCountryParser();
            case CITY_REGION_COUNTRY: return new CityRegionCountryParser();
            default: throw new UnsupportedLocationStrTypeException();
        }
    }
}
