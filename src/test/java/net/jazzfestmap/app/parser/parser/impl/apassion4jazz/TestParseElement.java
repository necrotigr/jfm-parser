package net.jazzfestmap.app.parser.parser.impl.apassion4jazz;

import net.jazzfestmap.app.parser.parser.HtmlFestival;
import net.jazzfestmap.app.parser.parser.InvalidFestivalFormatException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Сергей on 16.02.2017.
 */
public class TestParseElement {


    private Element readLi(String sample) {
        Document doc = Jsoup.parse(sample);
        Elements select = doc.select("li");
        Element li = select.first();
        return li;
    }

    @Test
    public void parseElement() throws InvalidFestivalFormatException {
        String sample = "<li><a href=\"http://www.kultuur.ut.ee/et/koolijazz\" target=\"_new\" rel=\"nofollow\">Koolijazz</a> - 3 to 5<br>" +
                "              Viljandi, Estonia </li>";
        APassion4JazzParser parser = new APassion4JazzParser();
        HtmlFestival htmlFestival = parser.readEventItem(readLi(sample));
        assertNotNull(htmlFestival);
        Assert.assertEquals("Koolijazz", htmlFestival.getName());
        Assert.assertEquals("http://www.kultuur.ut.ee/et/koolijazz", htmlFestival.getSiteUrl());
        Assert.assertEquals("3 to 5", htmlFestival.getDates());
        Assert.assertEquals("Viljandi, Estonia", htmlFestival.getLocation());
    }

    @Test
    public void parseElementWithMore() throws InvalidFestivalFormatException {
        String sample = "<li><a href=\"http://www.uidaho.edu/jazzfest\" target=\"_new\" rel=\"nofollow\">Lionel Hampton Jazz Festival</a> - 23 to 25<br>" +
                "              Moscow, ID, USA&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"hampton.html\">more...</a> </li>";
        APassion4JazzParser parser = new APassion4JazzParser();
        HtmlFestival htmlFestival = parser.readEventItem(readLi(sample));
        assertNotNull(htmlFestival);
        Assert.assertEquals("Lionel Hampton Jazz Festival", htmlFestival.getName());
        Assert.assertEquals("http://www.uidaho.edu/jazzfest", htmlFestival.getSiteUrl());
        Assert.assertEquals("23 to 25", htmlFestival.getDates());
        Assert.assertEquals("Moscow, ID, USA", htmlFestival.getLocation());
    }
}
