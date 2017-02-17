package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.parsers;

import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.DateRange;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.DateStrParser;

import java.time.Month;
import java.time.Year;

/**
 * Created by Сергей on 16.02.2017.
 */
public class AmpersandNextMonthParser implements DateStrParser {

    /**
     *
     * @param dateStr  31 & April 1
     * @param month
     * @param year
     * @return
     */
    @Override
    public DateRange parse(String dateStr, String month, String year) {
        String[] parts = dateStr.split("&");
        int startDay = Integer.valueOf(parts[0].trim());
        Month endMonth = Month.valueOf(parts[1].trim().split(" ")[0].toUpperCase());
        int endDay = Integer.valueOf(parts[1].trim().split(" ")[1]);

        DateRange dateRange = new DateRange(Month.valueOf(month), Year.parse(year));
        dateRange.setStartMonth(Month.valueOf(month));
        dateRange.setStartDay(startDay);
        dateRange.setEndMonth(endMonth);
        dateRange.setEndDay(endDay);
        return dateRange;
    }
}
