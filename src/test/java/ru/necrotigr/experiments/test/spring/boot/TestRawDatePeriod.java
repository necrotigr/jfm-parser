package ru.necrotigr.experiments.test.spring.boot;

import org.junit.Assert;
import org.junit.Test;
import ru.necrotigr.experiments.spring.boot.parser.RawDatePeriod;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
public class TestRawDatePeriod {

    /*
    1) Dates: October 25, 2011
            2) Dates: June 19–25, 2011
            3) Dates: October 25 – November 6, 2011
            4) Dates: October 25, 2011 – November 6, 2012 (2 запятых)
            */

    // 1) Dates: October 25, 2011
    @Test
    public void test1Variant() {
        RawDatePeriod period = RawDatePeriod.parseDate1Variant("October 25, 2011");
        Date startDate = period.getStartDate();
        Date endDate = period.getEndDate();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 25);
        calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar.set(Calendar.YEAR, 2011);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Assert.assertEquals(startDate.getTime(), endDate.getTime());
        Assert.assertEquals(calendar.getTime().getTime(), endDate.getTime());
    }

    // 2) Dates: June 19–25, 2011
    @Test
    public void test2Variant() {
        RawDatePeriod period = RawDatePeriod.parseDate2Variant("June 19–25, 2011");
        Date startDate = period.getStartDate();
        Date endDate = period.getEndDate();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 19);
        calendar1.set(Calendar.MONTH, Calendar.JUNE);
        calendar1.set(Calendar.YEAR, 2011);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        Date startCalDate = calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 25);
        calendar2.set(Calendar.MONTH, Calendar.JUNE);
        calendar2.set(Calendar.YEAR, 2011);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);

        Date endCalDate = calendar2.getTime();

        Assert.assertNotEquals(startDate.getTime(), endDate.getTime());
        Assert.assertEquals(startCalDate.getTime(), startDate.getTime());
        Assert.assertEquals(endCalDate.getTime(), endDate.getTime());
    }

    // 3) Dates: October 25 – November 6, 2011
    @Test
    public void test3Variant() {
        RawDatePeriod period = RawDatePeriod.parseDate3Variant("October 25 – November 6, 2011");
        Date startDate = period.getStartDate();
        Date endDate = period.getEndDate();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 25);
        calendar1.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar1.set(Calendar.YEAR, 2011);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        Date startCalDate = calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 6);
        calendar2.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar2.set(Calendar.YEAR, 2011);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);

        Date endCalDate = calendar2.getTime();

        Assert.assertNotEquals(startDate.getTime(), endDate.getTime());
        Assert.assertEquals(startCalDate.getTime(), startDate.getTime());
        Assert.assertEquals(endCalDate.getTime(), endDate.getTime());
    }

    // 4) Dates: October 25, 2011 – November 6, 2012 (2 запятых)
    @Test
    public void test4Variant() {
        RawDatePeriod period = RawDatePeriod.parseDate4Variant("October 25, 2011 – November 6, 2012");
        Date startDate = period.getStartDate();
        Date endDate = period.getEndDate();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 25);
        calendar1.set(Calendar.MONTH, Calendar.OCTOBER);
        calendar1.set(Calendar.YEAR, 2011);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);

        Date startCalDate = calendar1.getTime();

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 6);
        calendar2.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar2.set(Calendar.YEAR, 2012);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);

        Date endCalDate = calendar2.getTime();

        Assert.assertNotEquals(startDate.getTime(), endDate.getTime());
        Assert.assertEquals(startCalDate.getTime(), startDate.getTime());
        Assert.assertEquals(endCalDate.getTime(), endDate.getTime());
    }

}
