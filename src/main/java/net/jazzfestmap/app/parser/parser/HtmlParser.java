package net.jazzfestmap.app.parser.parser;

import net.jazzfestmap.app.parser.api.Festival;

import java.io.InputStream;
import java.util.Collection;

/**
 * Created by Сергей on 28.06.2015.
 *
 * Интерфейс для парсинга HTML-файлов
 *
 */
public interface HtmlParser {

    Collection<Festival> parse(InputStream inputStream);

}
