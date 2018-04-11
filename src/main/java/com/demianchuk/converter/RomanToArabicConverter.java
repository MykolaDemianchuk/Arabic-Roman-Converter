package com.demianchuk.converter;

import com.demianchuk.checker.RomanNumeralChecker;
import com.demianchuk.util.ConverterUtil;

import java.util.stream.Collectors;

public class RomanToArabicConverter implements NumeralConverter {

    @Override
    public String convert(String value) {
        System.out.println(value);
        return RomanNumeralChecker.splitRoman(value).stream()
                .collect(Collectors.summingInt(ConverterUtil::getArabicRepresentation))
                .toString();
    }
}