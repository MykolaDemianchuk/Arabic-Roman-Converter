package com.demianchuk.converter;

import com.demianchuk.exceptions.*;
import static com.demianchuk.util.ConverterUtil.*;

public class ArabicToRomanConverter implements NumeralConverter {

    @Override
    public String convert(String value) throws Exception {
        int arabic = getValidArabic(value);
        String roman = getRoman(arabic);
        return roman;
    }

    private static int getValidArabic(String value) throws Exception {
        int arabic = 0;
        try {
            arabic = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalInputException();
        }
        if (isOutOfRange(arabic)) {
            throw new IllegalArabicException();
        }
        return arabic;
    }

    private static String getRoman(int value) {
        int closestValue = getClosestArabicTo(value);
        if (closestValue == value) {
            return getRomanRepresentation(value);
        }
        int residualValue = value - closestValue;
        return getRomanRepresentation(closestValue) + getRoman(residualValue);
    }
}
