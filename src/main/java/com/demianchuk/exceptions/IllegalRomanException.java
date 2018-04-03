package com.demianchuk.exceptions;

public class IllegalRomanException extends Exception {

    public static final String ERR_MSG = "Illegal roman numeral";

    public IllegalRomanException() {
        super(ERR_MSG);
    }
}
