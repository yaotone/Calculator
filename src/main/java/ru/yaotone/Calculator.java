package ru.yaotone;

public class Calculator{

    public static String calculate(String num1, String operation, String num2) {
        if(TypeChecker.defineType(num1, num2) == TypeChecker.NumberType.Arabic){
            return ArabicCalculator.calculate(Converter.StringToInt(num1), operation, Converter.StringToInt(num2));
        }
        else {
            return Converter.intToRoman(RomanCalculator.calculate(Converter.RomanToInt(num1), operation, Converter.RomanToInt(num2)));
        }
    }
}
