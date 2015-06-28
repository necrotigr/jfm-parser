package ru.necrotigr.experiments.spring.boot.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Сергей on 28.06.2015.
 */
public class RawDate {

    private String day;
    private String month;
    private String year;

    public RawDate() {

    }

    public Date toDate() {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
            return sdf.parse(day + "-" + month + "-" + year);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date(0);
        }
    }

    public RawDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day + " " + month + " " + year;
    }
}
