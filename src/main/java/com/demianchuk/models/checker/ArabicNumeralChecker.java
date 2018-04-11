package com.demianchuk.models.checker;

public class ArabicNumeralChecker extends NumeralChecker {
    private static final int NUMERAL_MIN = 1;
    private static final int NUMERAL_MAX = 3999;

    @Override
    boolean isValid(String numeral){
        int validNumeral;
        try {
            validNumeral = Integer.parseInt(numeral);
        } catch (NumberFormatException e) {
            return false;
        }
        return ! isOutOfRange(validNumeral);
    }

    private boolean isOutOfRange(int numeral) {
        return numeral < NUMERAL_MIN || numeral > NUMERAL_MAX;
    }
}
