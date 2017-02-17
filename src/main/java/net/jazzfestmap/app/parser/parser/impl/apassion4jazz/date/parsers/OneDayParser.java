package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.parsers;

import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.DateRange;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.DateStrParser;

import java.time.Month;
import java.time.Year;

/**
 * Created by Сергей on 16.02.2017.
 */
public class OneDayParser implements DateStrParser {

    @Override
    public DateRange parse(String dateStr, String month, String year) {

        int startDay = Integer.valueOf(dateStr);
        int endDay = startDay;

        DateRange dateRange = new DateRange(Month.valueOf(month), Year.parse(year));
        dateRange.setStartMonth(Month.valueOf(month));
        dateRange.setStartDay(startDay);
        dateRange.setEndMonth(Month.valueOf(month));
        dateRange.setEndDay(endDay);
        return dateRange;
    }
}
