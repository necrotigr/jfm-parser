package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date;

import org.junit.Test;

/**
 * Created by Сергей on 17.02.2017.
 */
public class TestDateParser {

    /**
     * Just check for correctness
     * @throws UnsupportedDateStrTypeException
     */
    @Test
    public void testDateParser() throws UnsupportedDateStrTypeException {
        DateStrTypeDetector detector = new DateStrTypeDetector();
        String[] dates = {"7 & 8", "31 & April 1", "cancelled", "TBA", "11", "7 to 8", "31 to April 1"};
        String month = "April";
        String year = "2017";
        for (String dateStr : dates) {
            DateStrType dateStrType = detector.detect(dateStr);
            DateStrParser parser = DateStrParserFactory.createParser(dateStrType);
            DateRange dateRange = parser.parse(dateStr, month.toUpperCase(), year);
        }

    }
}
