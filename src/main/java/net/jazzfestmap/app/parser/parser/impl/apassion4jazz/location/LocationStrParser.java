package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location;

import net.jazzfestmap.app.parser.api.City;

import java.util.Collection;

/**
 * Created by Сергей on 16.02.2017.
 */
public interface LocationStrParser {

    Collection<City> parse(String locationStr);
}
