package com.demianchuk.models.checker;

import java.util.*;

import com.demianchuk.util.ConverterUtil;

public class RomanNumeralChecker extends NumeralChecker {

    @Override
    boolean isValid(String numeral) {
        return isInCorrectOrder(ConverterUtil.splitRoman(numeral));
    }

    private boolean isInCorrectOrder(List<String> romans) {
        if (romans == null)
            return false;
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
                    return false;
                }
                repCount = 0;
                continue;
            }
            return false;
        }
        return true;
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
