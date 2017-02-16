package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date;

import java.time.Month;
import java.time.Year;
import java.util.Date;

/**
 * Created by Сергей on 16.02.2017.
 */
public class DateRange {

    private Month startMonth;
    private Month endMonth;
    private Date startDate;
    private Date endDate;
    private Integer startDay;
    private Integer endDay;
    private Year year;

    public DateRange(Month startMonth, Year year) {
        this.startMonth = startMonth;
        this.year = year;
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
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date[] getDateRange() {
        return new Date[]{startDate, endDate};
    }
}
