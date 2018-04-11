package com.demianchuk.controller;

import com.demianchuk.checker.NumeralChecker;
import com.demianchuk.converter.NumeralConverter;
import com.demianchuk.view.ConverterView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArabicController extends ConverterController {

    public ArabicController(ConverterView view, NumeralChecker checker,
                            NumeralConverter converter) {
        super(view, checker, converter);
        this.view.addArabicListener(new ArabicListener());
    }

    class ArabicListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (isEnter(e)) {
                performAction(view.getArabicTextField(), view.getRomanTextField());
            }
        }
    }
}
