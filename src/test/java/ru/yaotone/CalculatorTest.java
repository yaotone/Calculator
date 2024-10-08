package ru.yaotone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.MissingFormatArgumentException;

class CalculatorTest {
    @Test
    void throwDifferentTypesException_differentTypes(){
        Assertions.assertThrows(DifferentTypesException.class, ()->Calculator.calculate("X","/", "5"));
    }

    @Test
    void throwFormatException_invalidRomanNumber(){
        Assertions.assertThrows(MissingFormatArgumentException.class, ()->Calculator.calculate("XQ","/", "X"));
    }

    @Test
    void throwInvalidNumberValue_tooLowArabic(){
        Assertions.assertThrows(InvalidNumberValue.class, ()->Calculator.calculate("-1","/", "5"));
    }

    @Test
    void throwInvalidNumberValue_tooBigArabic(){
        Assertions.assertThrows(InvalidNumberValue.class, ()->Calculator.calculate("11","/", "5"));
    }

    @Test
    void throwInvalidNumberValue_tooBigRoman(){
        Assertions.assertThrows(InvalidNumberValue.class, ()->Calculator.calculate("XI","/", "I"));
    }

    @Test
    void throwFormatException_lowCaseRoman(){
        Assertions.assertThrows(MissingFormatArgumentException.class, ()->Calculator.calculate("x","/", "IX"));
    }

    @Test
    void throwArgumentException_stringArgument(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->Calculator.calculate("X","s", "IX"));
    }

    @Test
    void throwArgumentException_numberArgument(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->Calculator.calculate("X","1", "IX"));
    }

    @Test
    void throwArgumentException_symbolArgument(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->Calculator.calculate("X","`", "IX"));
    }

    @Test
    void testAddition_roman(){
        Assertions.assertEquals("XIII", Calculator.calculate("X", "+", "III"));
    }

    @Test
    void testSubtraction_roman(){
        Assertions.assertEquals("VII", Calculator.calculate("X", "-", "III"));
    }

    @Test
    void testMultiplication_roman(){
        Assertions.assertEquals("XXX", Calculator.calculate("X", "*", "III"));
    }

    @Test
    void testDivision_roman(){
        Assertions.assertEquals("III", Calculator.calculate("X", "/", "III"));
    }

    @Test
    void testAddition_arabic(){
        Assertions.assertEquals("13", Calculator.calculate("10", "+", "3"));
    }

    @Test
    void testSubtraction_arabic(){
        Assertions.assertEquals("7", Calculator.calculate("10", "-", "3"));
    }

    @Test
    void testMultiplication_arabic(){
        Assertions.assertEquals("30", Calculator.calculate("10", "*", "3"));
    }

    @Test
    void testDivision_arabic(){
        Assertions.assertEquals("3", Calculator.calculate("10", "/", "3"));
    }

    @Test
    void nullDivision(){
        Assertions.assertThrows(ArithmeticException.class, ()->Calculator.calculate("10", "/", "0"));
    }
}
