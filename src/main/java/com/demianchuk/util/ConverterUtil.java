package com.demianchuk.util;

import com.demianchuk.exceptions.IllegalInputException;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.*;

public class ConverterUtil {

    private static final int MIN_VALUE;
    private static final int MAX_VALUE;
    private static final NavigableMap<Integer, String> NUMERALS;

    static {
        MIN_VALUE = 1;
        MAX_VALUE = 3999;

        NUMERALS = new TreeMap<>(Collections.reverseOrder());
        NUMERALS.put(1000, "M");
        NUMERALS.put(900, "CM");
        NUMERALS.put(500, "D");
        NUMERALS.put(400, "CD");
        NUMERALS.put(100, "C");
        NUMERALS.put(90, "XC");
        NUMERALS.put(50, "L");
        NUMERALS.put(40, "XL");
        NUMERALS.put(10, "X");
        NUMERALS.put(9, "IX");
        NUMERALS.put(5, "V");
        NUMERALS.put(4, "IV");
        NUMERALS.put(1, "I");
    }

    public static boolean isOutOfRange(String value) throws IllegalInputException {
        int validValue;
        try {
            validValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalInputException();
        }
        return validValue < MIN_VALUE || validValue > MAX_VALUE;
    }

    public static Collection<String> getRomanValues() {
        return NUMERALS.values();
    }

    public static String getRomanRepresentation(int arabic) {
        return NUMERALS.get(arabic);
    }

    public static int getArabicRepresentation(String roman) {
        return NUMERALS.entrySet()
                .stream()
                .filter(map -> map.getValue().equals(roman))
                .mapToInt(map -> map.getKey())
                .sum();
    }

    public static int getClosestArabicTo(int arabic) {
        return NUMERALS.ceilingKey(arabic);
    }

    public static boolean isLegalToRepeat(int value) {
        return startsWithOne(value);
    }

    public static boolean startsWithOne(int value) {
        return String.valueOf(value).startsWith("1");
    }

    public static boolean startsWithFive(int value) {
        return String.valueOf(value).startsWith("5");
    }

    public static boolean isSameBase(int first, int second) {
        return String.valueOf(first).length() == String.valueOf(second).length();
    }
}
