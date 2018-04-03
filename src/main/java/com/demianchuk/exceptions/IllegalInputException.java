package com.demianchuk.exceptions;

public class IllegalInputException extends Exception {

    public static final String ERR_MSG = "Illegal symbol appears";

    public IllegalInputException() {
        super(ERR_MSG);
    }
}
