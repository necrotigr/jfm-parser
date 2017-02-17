package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date;

import net.jazzfestmap.app.parser.api.DateType;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Сергей on 16.02.2017.
 */
public class DateRange {

    private Month startMonth;
    private Month endMonth;
    private Integer startDay;
    private Integer endDay;
    private Year year;
    private DateType dateType;

    public DateRange(Month startMonth, Year year) {
        this.startMonth = startMonth;
        this.year = year;
    }

    public DateType getDateType() {
        return dateType;
    }

    public void setDateType(DateType dateType) {
        this.dateType = dateType;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    public Integer getEndDay() {
        return endDay;
    }

    public void setEndDay(Integer endDay) {
        this.endDay = endDay;
    }

    public Month getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Month startMonth) {
        this.startMonth = startMonth;
    }

    public Month getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Month endMonth) {
        this.endMonth = endMonth;
    }

    public Date getStartDate() {
        if (dateType == DateType.CANCELLED  || dateType == DateType.TBA)
            return new Date(0);
        int day = (startDay == null) ? endDay : startDay;
        LocalDate localDate = LocalDate.of(year.getValue(), startMonth, day);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public Date getEndDate() {
        if (dateType == DateType.CANCELLED  || dateType == DateType.TBA)
            return new Date(0);
        int day = (endDay == null) ? startDay : endDay;
        Month month = endMonth == null ? startMonth : endMonth;
        LocalDate localDate = LocalDate.of(year.getValue(), month, day);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
