package net.jazzfestmap.app.parser.parser.impl.apassion4jazz;

import net.jazzfestmap.app.parser.api.City;
import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.parser.FestivalAdaptor;
import net.jazzfestmap.app.parser.parser.HtmlFestival;
import net.jazzfestmap.app.parser.parser.data.JazzFestival;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Сергей on 16.02.2017.
 */
public class APassion4JazzFestAdaptor implements FestivalAdaptor {

    @Override
    public Festival convert(HtmlFestival htmlFestival) {
        JazzFestival festival = new JazzFestival();

        festival.setUrl(htmlFestival.getSiteUrl()); // ссылка всегда правильная (наверняка)
        festival.setName(htmlFestival.getName());

        Date[] dates = parseDateString(htmlFestival.getDates());
        festival.setStartDate(dates[0]);
        festival.setEndDate(dates[1]);
        festival.setCities(parseLocationString(htmlFestival.getLocation()));

        return festival;
    }

    private Collection<City> parseLocationString(String location) {
        return null;
    }

    private Date[] parseDateString(String dates) {
        return new Date[0];
    }
}
