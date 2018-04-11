package com.demianchuk.models.checker;

import java.util.*;

import com.demianchuk.exceptions.IllegalInputException;
import com.demianchuk.exceptions.IllegalRomanException;
import com.demianchuk.util.ConverterUtil;

public class RomanNumeralChecker extends NumeralChecker {

    @Override
    boolean isValid(String numeral) throws Exception {
        if(wrongOrderOfNumerals(splitRoman(numeral)))
            throw new IllegalRomanException();
        return true;
    }

    public static List<String> splitRoman(String roman) throws IllegalInputException {
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
                throw new IllegalInputException();
            }
        }
        return romans;
    }

    private boolean wrongOrderOfNumerals(List<String> romans){
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
                    return true;
                }
                repCount = 0;
                continue;
            }
            return true;
        }
        return false;
    }

    private boolean isLegalToRepeat(int value) {
        return startsWithOne(value);
    }

    private boolean startsWithOne(int value) {
        return String.valueOf(value).startsWith("1");
    }

    private boolean startsWithFive(int value) {
        return String.valueOf(value).startsWith("5");
    }

    private boolean isSameBase(int first, int second) {
        return String.valueOf(first).length() == String.valueOf(second).length();
    }
}
