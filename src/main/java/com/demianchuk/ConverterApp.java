package com.demianchuk;

import com.demianchuk.controller.*;
import com.demianchuk.models.checker.*;
import com.demianchuk.models.converter.*;
import com.demianchuk.view.*;


public class ConverterApp {

    public static void main(String[] args) {
        new ConverterApp().go();
    }

    private void go() {
        ConverterView view = new ConverterView();
        new ArabicController(view, new ArabicNumeralChecker(), new ArabicToRomanConverter());
        new RomanController(view, new RomanNumeralChecker(), new RomanToArabicConverter());
    }
}

