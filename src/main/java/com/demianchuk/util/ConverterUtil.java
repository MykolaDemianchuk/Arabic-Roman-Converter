package com.demianchuk.util;

import java.util.*;

public class ConverterUtil {
    private static final NavigableMap<Integer, String> NUMERALS;

    static {
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

    public static String getValidValue(String value) {
        return value.trim().toUpperCase();
    }

    public static String getRomanRepresentation(int arabic) {
        return NUMERALS.get(arabic);
    }

    public static int getClosestArabicTo(int arabic) {
        return NUMERALS.ceilingKey(arabic);
    }

    public static Collection<String> getRomanValues() {
        return NUMERALS.values();
    }

    public static int getArabicRepresentation(String roman) {
        return NUMERALS.entrySet()
                .stream()
                .filter(map -> map.getValue().equals(roman))
                .mapToInt(map -> map.getKey())
                .sum();
    }

    public static List<String> splitRoman(String roman) {
        List<String> romans = new ArrayList<>();
        boolean found;
        while (!roman.isEmpty()) {
            found = false;
            for (String value : ConverterUtil.getRomanValues()) {
                if (roman.startsWith(value)) {
                    romans.add(value);
                    roman = roman.substring(value.length());
                    found = true;
                }
            }
            if (!found) {
                return null;
            }
        }
        return romans;
    }
}
