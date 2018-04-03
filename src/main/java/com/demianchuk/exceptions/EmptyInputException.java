package com.demianchuk.exceptions;

public class EmptyInputException extends Exception {

    public static final String ERR_MSG = "Nothing to convert";

    public EmptyInputException() {
        super(ERR_MSG);
    }
}
