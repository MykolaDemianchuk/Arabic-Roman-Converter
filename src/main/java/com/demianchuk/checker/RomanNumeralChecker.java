package com.demianchuk.checker;

import java.util.*;
import com.demianchuk.util.ConverterUtil;

public class RomanNumeralChecker implements NumeralChecker {

    @Override
    public boolean isLegalNumeral(String numeral) {
        checkPositioning(splitRoman(numeral));
        return true;
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
                //throw new IllegalInputException();
            }
        }
        return romans;
    }

    public void checkPositioning(List<String> romans) {
        int repCount = 0;

        for (int i = 0; i < romans.size() - 1; i++) {
            String roman = romans.get(i);
            String nextRoman = romans.get(i + 1);
            int value = ConverterUtil.getArabicRepresentation(roman);
            int nextValue = ConverterUtil.getArabicRepresentation(nextRoman);

            if (value == nextValue && isLegalToRepeat(value) && ++repCount < 3) {
                continue;
            }

            if (value > nextValue) {
                if (isSameBase(value, nextValue)
                        && (!startsWithFive(value) || !startsWithOne(nextValue))) {
                    //throw new IllegalRomanException();
                }
                repCount = 0;
                continue;
            }
           // throw new IllegalRomanException();
        }
    }

    private boolean isLegalToRepeat(int value) {
        return startsWithOne(value);
    }

    public boolean startsWithOne(int value) {
        return String.valueOf(value).startsWith("1");
    }

    public boolean startsWithFive(int value) {
        return String.valueOf(value).startsWith("5");
    }

    public boolean isSameBase(int first, int second) {
        return String.valueOf(first).length() == String.valueOf(second).length();
    }
}
