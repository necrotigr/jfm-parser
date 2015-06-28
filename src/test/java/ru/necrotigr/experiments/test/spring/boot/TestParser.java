package ru.necrotigr.experiments.test.spring.boot;

import org.junit.Assert;
import org.junit.Test;
import ru.necrotigr.experiments.spring.boot.api.Festival;
import ru.necrotigr.experiments.spring.boot.parser.FestsParser;
import ru.necrotigr.experiments.spring.boot.parser.HtmlParser;

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

        String fileName = "D:\\projects\\test-spring-boot\\src\\test\\samples\\Jazz Festivals in Europe July 2015.htm";
        InputStream inputStream = new FileInputStream(fileName);
        HtmlParser parser = new FestsParser();
        Collection<Festival> festivals = parser.parse(inputStream);

        Assert.assertNotNull(festivals);
        Assert.assertTrue(festivals.size() > 0);
    }
}
