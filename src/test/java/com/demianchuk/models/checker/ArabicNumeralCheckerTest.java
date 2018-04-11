package com.demianchuk.models.checker;

import com.demianchuk.util.ConverterUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArabicNumeralCheckerTest {

    NumeralChecker checker;
    List<String> legalInput;
    List<String> illegalInput;

    @Before
    public void setUp() {
        checker = new ArabicNumeralChecker();
        legalInput = Arrays.asList(
                "1", "01", "3999", "  3999",
                "    12", "   5  ", "00000003999");

        illegalInput = Arrays.asList(
                "0", "1.1", "4000", "100i",
                "   3 4 ", "  ", "", "XV");
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