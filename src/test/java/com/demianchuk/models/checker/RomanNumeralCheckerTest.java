package com.demianchuk.models.checker;

import com.demianchuk.util.ConverterUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RomanNumeralCheckerTest {

    NumeralChecker checker;
    List<String> legalInput;
    List<String> illegalInput;

    @Before
    public void setUp() {
        checker = new RomanNumeralChecker();
        legalInput = Arrays.asList(
                "iii", "IiI", "   XXX", "XXIX",
                "MMMCMXCIX", "d", "DCCC");

        illegalInput = Arrays.asList(
                "", "  ", "1", "s", "ivi",
                "IIs", "iiII", "IVV", "IXC",
                "MM M","XR","dd");
    }

    @Test
    public void isLegalNumeral() {
        for(String input : legalInput) {
            input = ConverterUtil.getValidValue(input);
            assertTrue(checker.isLegalNumeral(input));
        }

        for(String input : illegalInput) {
            input = ConverterUtil.getValidValue(input);
            assertFalse(checker.isLegalNumeral(input));
        }
    }
}