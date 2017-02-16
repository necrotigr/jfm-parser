package net.jazzfestmap.app.parser.parser.impl.apassion4jazz;

import net.jazzfestmap.app.parser.api.City;
import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.parser.FestivalAdaptor;
import net.jazzfestmap.app.parser.parser.HtmlFestival;
import net.jazzfestmap.app.parser.parser.data.JazzFestival;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.*;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location.*;

import java.util.Collection;

/**
 * Created by Сергей on 16.02.2017.
 */
public class APassion4JazzFestAdaptor implements FestivalAdaptor {

    private DateStrTypeDetector dateStrTypeDetector = new DateStrTypeDetector();

    private LocationStrTypeDetector locationStrTypeDetector = new LocationStrTypeDetector();


    @Override
    public Festival convert(HtmlFestival htmlFestival) {
        JazzFestival festival = new JazzFestival();
        try {

            festival.setUrl(htmlFestival.getSiteUrl()); // ссылка всегда правильная (наверняка)
            festival.setName(htmlFestival.getName());

            DateRange dates = parseDateString(htmlFestival.getDates(), htmlFestival.getHeldMonth(), htmlFestival.getHeldYear());
            festival.setStartDate(dates.getStartDate());
            festival.setEndDate(dates.getEndDate());
            festival.setCities(parseLocationString(htmlFestival.getLocation()));

            return festival;
        } catch (UnsupportedLocationStrTypeException e) {
            e.printStackTrace();
            return festival;
        } catch (UnsupportedDateStrTypeException e) {
            e.printStackTrace();
            return festival;
        }
    }

    private Collection<City> parseLocationString(String location) throws UnsupportedLocationStrTypeException {
        LocationStrType locationStrType = locationStrTypeDetector.detect(location);
        LocationStrParser parser = LocationStrTypeFactory.create(locationStrType);
        return parser.parse(location);
    }

    private DateRange parseDateString(String dates, String month, String year) throws UnsupportedDateStrTypeException {
        DateStrType dateStrType = dateStrTypeDetector.detect(dates);
        DateStrParser parser = DateStrParserFactory.createParser(dateStrType);
        return parser.parse(dates, month, year);
    }
}
