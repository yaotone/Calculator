package ru.yaotone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yaotone.exception.DifferentTypesException;
import ru.yaotone.exception.InvalidNumberValue;

import java.util.MissingFormatArgumentException;

class CalculatorTest {
    private Calculator NumberCalculator;

    @BeforeEach
    void createClass(){
        NumberCalculator = new NumberCalculator();
    }

    @Test
    void throwDifferentTypesException_differentTypes(){
        Assertions.assertThrows(DifferentTypesException.class, ()-> NumberCalculator.calculate("X","/", "5"));
    }

    @Test
    void throwFormatException_invalidRomanNumber(){
        Assertions.assertThrows(MissingFormatArgumentException.class, ()-> NumberCalculator.calculate("XQ","/", "X"));
    }

    @Test
    void throwInvalidNumberValue_tooLowArabic(){
        Assertions.assertThrows(InvalidNumberValue.class, ()-> NumberCalculator.calculate("-1","/", "5"));
    }

    @Test
    void throwInvalidNumberValue_tooBigArabic(){
        Assertions.assertThrows(InvalidNumberValue.class, ()-> NumberCalculator.calculate("11","/", "5"));
    }

    @Test
    void throwInvalidNumberValue_tooBigRoman(){
        Assertions.assertThrows(InvalidNumberValue.class, ()-> NumberCalculator.calculate("XI","/", "I"));
    }

    @Test
    void throwFormatException_lowCaseRoman(){
        Assertions.assertThrows(MissingFormatArgumentException.class, ()-> NumberCalculator.calculate("x","/", "IX"));
    }

    @Test
    void throwArgumentException_stringArgument(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> NumberCalculator.calculate("X","s", "IX"));
    }

    @Test
    void throwArgumentException_numberArgument(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> NumberCalculator.calculate("X","1", "IX"));
    }

    @Test
    void throwArgumentException_symbolArgument(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> NumberCalculator.calculate("X","`", "IX"));
    }

    @Test
    void testAddition_roman(){
        Assertions.assertEquals("XIII", NumberCalculator.calculate("X", "+", "III"));
    }

    @Test
    void testSubtraction_roman(){
        Assertions.assertEquals("VII", NumberCalculator.calculate("X", "-", "III"));
    }

    @Test
    void testMultiplication_roman(){
        Assertions.assertEquals("XXX", NumberCalculator.calculate("X", "*", "III"));
    }

    @Test
    void testDivision_roman(){
        Assertions.assertEquals("III", NumberCalculator.calculate("X", "/", "III"));
    }

    @Test
    void testAddition_arabic(){
        Assertions.assertEquals("13", NumberCalculator.calculate("10", "+", "3"));
    }

    @Test
    void testSubtraction_arabic(){
        Assertions.assertEquals("7", NumberCalculator.calculate("10", "-", "3"));
    }

    @Test
    void testMultiplication_arabic(){
        Assertions.assertEquals("30", NumberCalculator.calculate("10", "*", "3"));
    }

    @Test
    void testDivision_arabic(){
        Assertions.assertEquals("3", NumberCalculator.calculate("10", "/", "3"));
    }

    @Test
    void nullDivision(){
        Assertions.assertThrows(ArithmeticException.class, ()-> NumberCalculator.calculate("10", "/", "0"));
    }
}
