package com.demianchuk.models.converter;

import com.demianchuk.util.ConverterUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanToArabicConverterTest {

    NumeralConverter converter;

    @Before
    public void setUp() {
        converter = new RomanToArabicConverter();
    }

    @Test
    public void convert() {
        assertConvertible("15", "XV");
        assertConvertible("1", "i");
        assertConvertible("3999", "mmmCMxCiX");
        assertConvertible("954", "CMLiv   ");
        assertConvertible("803", "   DCCCiii");
        assertConvertible("2186", "mmCLxxxVI");
    }

    private void assertConvertible(String expected, String value) {
        value = ConverterUtil.getValidValue(value);
        assertEquals(expected, converter.convert(value));
    }
}