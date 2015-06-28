package ru.necrotigr.experiments.spring.boot.parser;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
public class RawDatePeriod {

    public static final String EN_DASH = "\u2013"; // знак "-" может быть закодирован как #&8211;

    private RawDate startDate;
    private RawDate endDate;

    // 1) Dates: October 25, 2011
    public static RawDatePeriod parseDate1Variant(String dateStr) {
        String[] strParts = dateStr.split(" ", 3);
        String month = strParts[0];
        String day = strParts[1].substring(0, strParts[1].indexOf(","));
        String year = strParts[2];
        RawDate date = new RawDate();
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);

        RawDatePeriod period = new RawDatePeriod(date, date);
        return period;
    }

    // 2) Dates: June 19–25, 2011
    public static RawDatePeriod parseDate2Variant(String dateStr) {

        String[] strParts = dateStr.split(" ", 3);
        String month = strParts[0];
        String year = strParts[2];
        String daysString = strParts[1].substring(0, strParts[1].indexOf(","));
        String days[] = daysString.split(EN_DASH);

        RawDate startDate = new RawDate();
        startDate.setDay(days[0]);
        startDate.setMonth(month);
        startDate.setYear(year);

        RawDate endDate = new RawDate();
        endDate.setDay(days[1]);
        endDate.setMonth(month);
        endDate.setYear(year);


        RawDatePeriod period = new RawDatePeriod(startDate, endDate);
        return period;
    }

    // * 3) Dates: October 25 – November 6, 2011
    public static RawDatePeriod parseDate3Variant(String dateStr) {
        String[] strParts = dateStr.split(" ", 6);
        String year = strParts[5];

        RawDate startDate = new RawDate();
        startDate.setDay(strParts[1]);
        startDate.setMonth(strParts[0]);
        startDate.setYear(year);

        RawDate endDate = new RawDate();
        endDate.setDay(strParts[4].substring(0, strParts[4].indexOf(",")));
        endDate.setMonth(strParts[3]);
        endDate.setYear(year);

        RawDatePeriod period = new RawDatePeriod(startDate, endDate);
        return period;
    }

    // * 4) Dates: October 25, 2011 – November 6, 2012 (2 запятых)
    public static RawDatePeriod parseDate4Variant(String dateStr) {
        String[] strParts = dateStr.split(" ", 7);


        RawDate startDate = new RawDate();
        startDate.setDay(strParts[1].substring(0, strParts[1].indexOf(",")));
        startDate.setMonth(strParts[0]);
        startDate.setYear(strParts[2]);

        RawDate endDate = new RawDate();
        endDate.setDay(strParts[5].substring(0, strParts[5].indexOf(",")));
        endDate.setMonth(strParts[4]);
        endDate.setYear(strParts[6]);

        RawDatePeriod period = new RawDatePeriod(startDate, endDate);
        return period;
    }

    public Date[] getDates() {
        Date[] dates = new Date[2];
        dates[0] = startDate.toDate();
        dates[1] = endDate.toDate();
        return dates;
    }

    public Date getStartDate() {
        return startDate.toDate();
    }

    public Date getEndDate() {
        return endDate.toDate();
    }


    public RawDate getRawStartDate() {
        return startDate;
    }

    public RawDate getRawEndDate() {
        return endDate;
    }

    public RawDatePeriod(RawDate startDate, RawDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }



    @Override
    public String toString() {
        return startDate + " - " + endDate;
    }
}
