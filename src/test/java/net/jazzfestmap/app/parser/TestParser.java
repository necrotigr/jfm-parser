package net.jazzfestmap.app.parser;

import org.junit.Assert;
import org.junit.Test;
import net.jazzfestmap.app.parser.api.Festival;
import net.jazzfestmap.app.parser.parser.FestsParser;
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

    @Test
    public void testGetAndParse() throws FileNotFoundException {

        String fileName = "src\\test\\samples\\Jazz Festivals in Europe July 2015.htm";
        InputStream inputStream = new FileInputStream(fileName);
        HtmlParser parser = new FestsParser();
        Collection<Festival> festivals = parser.parse(inputStream);

        Assert.assertNotNull(festivals);
        Assert.assertTrue(festivals.size() > 0);
    }
}
