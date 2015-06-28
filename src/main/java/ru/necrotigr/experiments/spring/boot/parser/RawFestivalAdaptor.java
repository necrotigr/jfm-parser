package ru.necrotigr.experiments.spring.boot.parser;

import ru.necrotigr.experiments.spring.boot.api.City;
import ru.necrotigr.experiments.spring.boot.api.Country;
import ru.necrotigr.experiments.spring.boot.api.Festival;
import ru.necrotigr.experiments.spring.boot.parser.data.FestCity;
import ru.necrotigr.experiments.spring.boot.parser.data.FestCountry;
import ru.necrotigr.experiments.spring.boot.parser.data.JazzFestival;

import java.util.*;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
public class RawFestivalAdaptor {

    public Festival convert(HtmlFestival htmlFestival) {
        JazzFestival festival = new JazzFestival();

        festival.setName(htmlFestival.getName());
        festival.setUrl(htmlFestival.getSiteUrl());
        Date[] dates = parseDateString(htmlFestival.getDates());
        festival.setStartDate(dates[0]);
        festival.setEndDate(dates[1]);
        festival.setCities(parseLocationString(htmlFestival.getLocation()));

        return festival;
    }

    /**
     * 1) Dates: October 25, 2011
     * 2) Dates: June 19–25, 2011
     * 3) Dates: October 25 – November 6, 2011
     * 4) Dates: October 25, 2011 – November 6, 2012 (2 запятых)
     */
    private Date[] parseDateString(String dateString) {
        dateString = dateString.trim();
        // 1й вариант
        if (!dateString.contains(RawDatePeriod.EN_DASH)) {
            return RawDatePeriod.parseDate1Variant(dateString).getDates();
            // 2й вариант
        } else if (dateString.contains(" " + RawDatePeriod.EN_DASH + " ")) {
            return RawDatePeriod.parseDate3Variant(dateString).getDates();
        }
        // 4й вариант
        else if (dateString.lastIndexOf(",") == 2) {
            return RawDatePeriod.parseDate4Variant(dateString).getDates();
        }
        // 3й вариант
        else {
            return RawDatePeriod.parseDate2Variant(dateString).getDates();
        }
    }


    /**
     * Мб варианты:
     * 1) Location: Moscow, Bryansk, Orel, Kursk, Lipetsk, Voronezh, Tula, Russia
     * 2) Location: Villingen-Schwenningen, Germany // TODO
     * 3) Location: Tallinn and Parnu, Estonia //TODO
     * Saint-Fons (nr Lyon), France
     *
     * @param locationString
     * @return
     */
    private Collection<City> parseLocationString(String locationString) {
        locationString = locationString.trim();
        String[] parts = locationString.split(",");
        List<String> cityStrs = new LinkedList<>(Arrays.asList(parts));
        String countryStr = cityStrs.get(cityStrs.size() - 1).trim();
        Country country = new FestCountry(countryStr);
        int lastIndex = cityStrs.size() - 1;
        cityStrs.remove(lastIndex);
        List<String> cityStrList = new ArrayList<>();
        for (String cityStr : cityStrs) {
            if (cityStr.contains(" and ")) {
                String[] cityPair = cityStr.split(" and ", 2);
                cityStrList.add(cityPair[0]);
                cityStrList.add(cityPair[1]);
            } else
                cityStrList.add(cityStr);
        }

        Collection<City> resultList = new LinkedList<>();
        for (String cityStr : cityStrList) {
            FestCity city = new FestCity();
            city.setCountry(country);
            city.setName(cityStr.trim());
            resultList.add(city);
        }

        return resultList;
    }
}
