package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Сергей on 16.02.2017.
 */
public class TestDateDetector {

    @Test
    public void testCorrect() throws UnsupportedDateStrTypeException {
        DateStrTypeDetector detector = new DateStrTypeDetector();
        assertEquals(DateStrType.AMPERSAND, detector.detect("7 & 8"));
        assertEquals(DateStrType.AMPERSAND_NEXT_MONTH, detector.detect("31 & April 1"));
        assertEquals(DateStrType.CANCELLED, detector.detect("cancelled"));
        assertEquals(DateStrType.TBA, detector.detect("TBA"));
        assertEquals(DateStrType.ONE_DAY, detector.detect("11"));
        assertEquals(DateStrType.SIMPLE_RANGE, detector.detect("7 to 8"));
        assertEquals(DateStrType.WITH_NEXT_MONTH, detector.detect("31 to April 1"));
    }

    @Test(expected = UnsupportedDateStrTypeException.class)
    public void testUnsupported() throws UnsupportedDateStrTypeException {
        DateStrTypeDetector detector = new DateStrTypeDetector();
        detector.detect("11 to 20, 2017");
        fail("11 to 20, 2017");
    }
}
