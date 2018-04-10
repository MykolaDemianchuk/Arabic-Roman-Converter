package com.demianchuk.converter;

import com.demianchuk.exceptions.*;
import static com.demianchuk.util.ConverterUtil.*;

public class ArabicToRomanConverter extends NumeralConverter {

    @Override
    protected String getConvertedNumeral(String value) {
        return getRoman(Integer.parseInt(value));
    }

    @Override
    protected String getValidNumeral(String value) throws Exception {
        if (isOutOfRange(value))
            throw new IllegalArabicException();
        return value;
    }

    private static String getRoman(int value) {
        int closestValue = getClosestArabicTo(value);
        if (closestValue == value)
            return getRomanRepresentation(value);
        return getRomanRepresentation(closestValue) + getRoman(value - closestValue);
    }
}
