package com.demianchuk.models.checker;

public abstract class NumeralChecker {
    public boolean isLegalNumeral(String numeral) {
        if (numeral.isEmpty())
            return false;
        return isValid(numeral);
    }

    abstract boolean isValid(String numeral);
}
