package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date;

/**
 * Created by Сергей on 16.02.2017.
 *
 * Поддерживаемые варианты строки даты в описании фестиваля
 */
public enum DateStrType {
    SIMPLE_RANGE, // 3 to 5
    ONE_DAY, // 11
    RANGE_BY_DAY_OF_WEEK, //12 to April 27 (Thursdays)
    TBA, // TBA
    CANCELLED, // cancelled
    WITH_NEXT_MONTH,    //23 to March 18
    AMPERSAND_NEXT_MONTH,  // 31 & April 1
    AMPERSAND,  // 7 & 8
    WITH_YEAR, // 11 to 20, 2017
}
