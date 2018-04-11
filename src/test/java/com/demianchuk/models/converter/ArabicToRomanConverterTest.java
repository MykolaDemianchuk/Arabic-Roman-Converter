package com.demianchuk.models.converter;

import com.demianchuk.util.ConverterUtil;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArabicToRomanConverterTest {

    NumeralConverter converter;

    @Before
    public void setUp() {
        converter = new ArabicToRomanConverter();
    }

    @Test
    public void convert() {
        assertConvertible("XV", " 15");
        assertConvertible("CXXIV", "  124");
        assertConvertible("MMMCMXCIX", "3999  ");
        assertConvertible("MCCXXXIV", "1234");
    }

    private void assertConvertible(String expected, String value) {
        value = ConverterUtil.getValidValue(value);
        assertEquals(expected, converter.convert(value));
    }
}