package net.jazzfestmap.app.parser.parser.impl.apassion4jazz.location;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Сергей on 16.02.2017.
 */
public class TestLocationDetector {

    @Test
    public void testLocationDetector() throws UnsupportedLocationStrTypeException {
        LocationStrTypeDetector detector = new LocationStrTypeDetector();

        assertEquals(LocationStrType.CITY_COUNTRY, detector.detect("Samois sur Seine, France"));
        assertEquals(LocationStrType.CITY_COUNTRY, detector.detect("Dubai, UAE"));

        assertEquals(LocationStrType.CITY_REGION_COUNTRY, detector.detect("Ascona, Lake Maggiore, Switzerland "));

        assertEquals(LocationStrType.CITY_STATE_COUNTRY, detector.detect("San Diego, CA, USA"));
        assertEquals(LocationStrType.CITY_STATE_COUNTRY, detector.detect("Saratoga Springs, NY, USA"));

    }

    @Test(expected = UnsupportedLocationStrTypeException.class)
    public void testUnsupported() throws UnsupportedLocationStrTypeException {
        LocationStrTypeDetector detector = new LocationStrTypeDetector();

        detector.detect("75 venues abross Denmark");
        fail("75 venues abross Denmark");
    }


}
