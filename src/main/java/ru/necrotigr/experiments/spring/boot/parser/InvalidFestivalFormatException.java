package ru.necrotigr.experiments.spring.boot.parser;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
public class InvalidFestivalFormatException extends Throwable {
    public InvalidFestivalFormatException(String html) {
        System.err.println("UnsupportedFestivalException: " + html);
    }
}
