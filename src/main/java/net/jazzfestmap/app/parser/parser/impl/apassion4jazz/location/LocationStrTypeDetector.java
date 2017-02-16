package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location;

/**
 * Created by Сергей on 16.02.2017.
 */
public class LocationStrTypeDetector {

    public LocationStrType detect(String locationStr) throws UnsupportedLocationStrTypeException {
        if (locationStr.matches("[\\w\\s]+[,]{1}[\\w\\s]+")) return LocationStrType.CITY_COUNTRY;
        if (locationStr.matches("(\\s*\\w\\s*)+,\\s*[A-Z]+\\s*,(\\s*\\w\\s*)+")) return LocationStrType.CITY_STATE_COUNTRY;
        if (locationStr.matches("(\\s*\\w+\\s*)*,(\\s*\\w+\\s*)*,(\\s*\\w+\\s*)*")) return LocationStrType.CITY_REGION_COUNTRY;
        throw new UnsupportedLocationStrTypeException();
    }
}
