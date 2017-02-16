package net.jazzfestmap.app.parser.parser;

import net.jazzfestmap.app.parser.api.Festival;

/**
 * Created by Сергей on 16.02.2017.
 */
public interface FestivalAdaptor {

    Festival convert(HtmlFestival htmlFestival);
}
