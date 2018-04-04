package com.demianchuk;

import com.demianchuk.converter.ArabicToRomanConverter;
import com.demianchuk.converter.RomanToArabicConverter;
import com.demianchuk.ui.ConverterUI;

public class App {
    public static void main(String[] args) {
        new ConverterUI(new ArabicToRomanConverter(), new RomanToArabicConverter());
    }
}
