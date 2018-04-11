package com.demianchuk;

import com.demianchuk.checker.*;
import com.demianchuk.controller.*;
import com.demianchuk.converter.*;
import com.demianchuk.view.*;


public class App {
    public static void main(String[] args) {
        new App().go();
    }

    private void go() {
        ConverterView view = new ConverterView();
        new ArabicController(view, new ArabicNumeralChecker(), new ArabicToRomanConverter());
        new RomanController(view, new RomanNumeralChecker(), new RomanToArabicConverter());
    }
}

