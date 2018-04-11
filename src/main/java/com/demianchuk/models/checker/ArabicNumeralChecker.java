package com.demianchuk.models.checker;

public class ArabicNumeralChecker implements NumeralChecker {
    private static final int NUMERAL_MIN = 1;
    private static final int NUMERAL_MAX = 3999;

    @Override
    public boolean isLegalNumeral(String numeral) {
        int checkedNumeral = 0;
        try {
            checkedNumeral = Integer.parseInt(numeral);
        } catch (NumberFormatException e) {
            //TODO
        }
        return !isOutOfRange(checkedNumeral);
    }

    private boolean isOutOfRange(int numeral) {
        return numeral < NUMERAL_MIN || numeral > NUMERAL_MAX;
    }
}
