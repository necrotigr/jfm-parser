package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date;

import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date.parsers.*;

/**
 * Created by Сергей on 16.02.2017.
 */
public class DateStrParserFactory {

    public static DateStrParser createParser(DateStrType dateStrType) throws UnsupportedDateStrTypeException {
        switch (dateStrType) {
            case AMPERSAND: return new AmpersandParser();
            case AMPERSAND_NEXT_MONTH: return new AmpersandNextMonthParser();
            case ONE_DAY: return new OneDayParser();
            case CANCELLED: return new CancelledParser();
            case TBA: return new TBAParser();
            case SIMPLE_RANGE: return new RangeParser();
            case WITH_NEXT_MONTH: return new WithNextMonthParser();
            default: throw new UnsupportedDateStrTypeException();
        }
    }
}
