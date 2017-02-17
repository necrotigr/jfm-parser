package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.parsers;

import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.DateRange;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.DateStrParser;

import java.time.Month;
import java.time.Year;

/**
 * Created by Сергей on 16.02.2017.
 */
public class WithNextMonthParser implements DateStrParser {

    @Override
    public DateRange parse(String dateStr, String month, String year) {

        String[] parts = dateStr.split("to");
        int startDay = Integer.valueOf(parts[0].trim());
        Month endMonth = Month.valueOf(parts[1].trim().split(" ")[0]);
        int endDay = Integer.valueOf(parts[1].trim().split(" ")[1]);

        DateRange dateRange = new DateRange(Month.valueOf(month), Year.parse(year));
        dateRange.setStartMonth(Month.valueOf(month));
        dateRange.setStartDay(startDay);
        dateRange.setEndMonth(endMonth);
        dateRange.setEndDay(endDay);
        return dateRange;
    }
}
