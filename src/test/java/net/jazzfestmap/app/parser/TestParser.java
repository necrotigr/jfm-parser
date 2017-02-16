package net.jazzfestmap.app.parser;

import net.jazzfestmap.app.parser.parser.impl.apassion4jazz.APassion4JazzParser;
import org.junit.Assert;
import org.junit.Test;
import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.parser.impl.old.jazzfests.JazzfestsParser;
import net.jazzfestmap.app.parser.parser.HtmlParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;

/**
 * Created by Сергей on 28.06.2015.
 *
 */
public class TestParser {

    /**
     * Тестирует сэмпл старой структуры - jazzfests.net
     * @throws FileNotFoundException
     */
    @Test
    public void testGetAndParseOldFormat() throws FileNotFoundException {
        String fileName = "src\\test\\samples\\Jazz Festivals in Europe July 2015.htm";
        InputStream inputStream = new FileInputStream(fileName);
        HtmlParser parser = new JazzfestsParser();
        Collection<Festival> festivals = parser.parse(inputStream);

        Assert.assertNotNull(festivals);
        Assert.assertTrue(festivals.size() > 0);
    }

    @Test
    public void testParseNewFormat() throws FileNotFoundException {
        String fileName = "src\\test\\samples\\Apassion4jazz-january.html";
        InputStream inputStream = new FileInputStream(fileName);
        HtmlParser parser = new APassion4JazzParser();
        Collection<Festival> festivals = parser.parse(inputStream);

        Assert.assertNotNull(festivals);
        Assert.assertTrue(festivals.size() > 0);
    }
}
