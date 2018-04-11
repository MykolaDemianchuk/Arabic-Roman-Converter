package com.demianchuk.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ConverterUtilTest {

    @Test
    public void getRomanRepresentation() {
        assertNull(ConverterUtil.getRomanRepresentation(0));
        assertNull(ConverterUtil.getRomanRepresentation(6));

        assertEquals("I", ConverterUtil.getRomanRepresentation(1));
        assertEquals("IV", ConverterUtil.getRomanRepresentation(4));
        assertEquals("V", ConverterUtil.getRomanRepresentation(5));
        assertEquals("IX", ConverterUtil.getRomanRepresentation(9));
        assertEquals("X", ConverterUtil.getRomanRepresentation(10));
        assertEquals("XL", ConverterUtil.getRomanRepresentation(40));
        assertEquals("L", ConverterUtil.getRomanRepresentation(50));
        assertEquals("XC", ConverterUtil.getRomanRepresentation(90));
        assertEquals("C", ConverterUtil.getRomanRepresentation(100));
        assertEquals("CD", ConverterUtil.getRomanRepresentation(400));
        assertEquals("D", ConverterUtil.getRomanRepresentation(500));
        assertEquals("CM", ConverterUtil.getRomanRepresentation(900));
        assertEquals("M", ConverterUtil.getRomanRepresentation(1000));
    }

    @Test
    public void getClosestArabicTo() {
        assertEquals(5, ConverterUtil.getClosestArabicTo(6));
        assertEquals(1000, ConverterUtil.getClosestArabicTo(1001));
        assertEquals(900, ConverterUtil.getClosestArabicTo(999));
        assertEquals(900, ConverterUtil.getClosestArabicTo(901));
        assertEquals(1000, ConverterUtil.getClosestArabicTo(3999));

        assertNotEquals(1000, ConverterUtil.getClosestArabicTo(999));
        assertNotEquals(3, ConverterUtil.getClosestArabicTo(4));
        assertNotEquals(50, ConverterUtil.getClosestArabicTo(49));
        assertNotEquals(900, ConverterUtil.getClosestArabicTo(899));
    }

    @Test
    public void getArabicRepresentation() {
        assertEquals(10, ConverterUtil.getArabicRepresentation("X"));
        assertEquals(1, ConverterUtil.getArabicRepresentation("I"));
        assertEquals(50, ConverterUtil.getArabicRepresentation("L"));
        assertEquals(40, ConverterUtil.getArabicRepresentation("XL"));

        assertNotEquals(15, ConverterUtil.getArabicRepresentation("XV"));
        assertNotEquals(101, ConverterUtil.getArabicRepresentation("CI"));
        assertNotEquals(4, ConverterUtil.getArabicRepresentation("IIII"));
        assertNotEquals(2, ConverterUtil.getArabicRepresentation("II"));
    }

    @Test
    public void splitRoman() {
        assertEquals(Arrays.asList("M", "M", "M", "XC", "IV"),
                ConverterUtil.splitRoman("MMMXCIV"));
        assertEquals(Arrays.asList("XL"),
                ConverterUtil.splitRoman("XL"));
        assertEquals(Arrays.asList("CD", "XL", "IV"),
                ConverterUtil.splitRoman("CDXLIV"));
        assertEquals(Arrays.asList("M", "C", "C", "X", "X", "X", "IV"),
                ConverterUtil.splitRoman("MCCXXXIV"));
        assertEquals(Arrays.asList("M", "M", "M", "CM", "XC", "I", "I", "I"),
                ConverterUtil.splitRoman("MMMCMXCIII"));

        assertNull(ConverterUtil.splitRoman("112"));
        assertNull(ConverterUtil.splitRoman("S XV"));
        assertNull(ConverterUtil.splitRoman("MMM W"));
    }
}