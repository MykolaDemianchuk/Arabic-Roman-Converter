package com.demianchuk.converter;

import com.demianchuk.util.ConverterUtil;

public class ArabicToRomanConverter implements NumeralConverter {

    @Override
    public String convert(String value) {
        return getRoman(Integer.parseInt(value));
    }

    private String getRoman(int value) {
        int closestValue = ConverterUtil.getClosestArabicTo(value);
        if (closestValue == value)
            return ConverterUtil.getRomanRepresentation(value);
        return ConverterUtil.getRomanRepresentation(closestValue)
                + getRoman(value - closestValue);
    }
}