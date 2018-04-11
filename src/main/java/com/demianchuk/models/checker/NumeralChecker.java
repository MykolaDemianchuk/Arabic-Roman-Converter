package com.demianchuk.models.checker;

import com.demianchuk.exceptions.EmptyInputException;

public abstract class NumeralChecker {
    public boolean isLegalNumeral(String numeral) throws Exception {
        if(numeral.isEmpty())
            throw new EmptyInputException();
        return isValid(numeral);
    }

    abstract boolean isValid(String numeral) throws Exception;
}
