package com.demianchuk.models.checker;

import com.demianchuk.exceptions.IllegalArabicException;
import com.demianchuk.exceptions.IllegalInputException;

public class ArabicNumeralChecker extends NumeralChecker {
    private static final int NUMERAL_MIN = 1;
    private static final int NUMERAL_MAX = 3999;

    @Override
    boolean isValid(String numeral) throws Exception {
        int checkedNumeral;
        try {
            checkedNumeral = Integer.parseInt(numeral);
        } catch (NumberFormatException e) {
            throw new IllegalInputException();
        }
        if(isOutOfRange(checkedNumeral))
            throw new IllegalArabicException();
        return true;
    }

    private boolean isOutOfRange(int numeral) {
        return numeral < NUMERAL_MIN || numeral > NUMERAL_MAX;
    }
}
