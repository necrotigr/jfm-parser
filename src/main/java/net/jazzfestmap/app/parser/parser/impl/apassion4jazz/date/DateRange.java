package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date;

import java.time.Month;
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

    public DateRange(Month startMonth) {
        this.startMonth = startMonth;
    }

    public DateRange(Integer startMonth) {
        this.startMonth = Month.of(startMonth);
    }

    public DateRange (String startMonth) {
        this.startMonth = Month.valueOf(startMonth);
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
        return new Date[] {startDate, endDate};
    }
}
