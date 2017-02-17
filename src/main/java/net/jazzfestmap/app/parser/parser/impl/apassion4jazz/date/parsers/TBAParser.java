package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.parsers;

import net.jazzfestmap.app.parser.api.DateType;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.DateRange;
import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.DateStrParser;

import java.time.Month;
import java.time.Year;

/**
 * Created by Сергей on 16.02.2017.
 */
public class TBAParser implements DateStrParser {

    @Override
    public DateRange parse(String dateStr, String month, String year) {
        DateRange dateRange = new DateRange(Month.valueOf(month), Year.parse(year));
        dateRange.setDateType(DateType.TBA);
        return dateRange;
    }
}
