package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date;

/**
 * Created by Сергей on 16.02.2017.
 */
public class DateStrTypeDetector {

    public DateStrType detect(String dateStr) throws UnsupportedDateStrTypeException {
        if (dateStr.matches("\\d+\\s*&\\s*\\d+")) return DateStrType.AMPERSAND;
        if (dateStr.matches("\\d+\\s*&\\s*\\w+\\s*\\d+")) return DateStrType.AMPERSAND_NEXT_MONTH;
        if (dateStr.contains("cancelled")) return DateStrType.CANCELLED;
        if (dateStr.contains("TBA")) return DateStrType.TBA;
        if (dateStr.matches("\\d+")) return DateStrType.ONE_DAY;
        if (dateStr.matches("\\d+\\s*to\\s*\\d+")) return DateStrType.SIMPLE_RANGE;
        if (dateStr.matches("\\d+\\s*to\\s*\\w+\\s*\\d+")) return DateStrType.WITH_NEXT_MONTH;

        throw new UnsupportedDateStrTypeException();
    }

}
