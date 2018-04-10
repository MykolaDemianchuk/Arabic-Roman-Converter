package com.demianchuk.converter;

public abstract class NumeralConverter {
    public String convert(String value) throws Exception {
        return getConvertedNumeral(getValidNumeral(value));
    }

    protected abstract String getConvertedNumeral(String value) throws Exception;
    protected abstract String getValidNumeral(String value) throws Exception;
}
